package com.haaris.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haaris.model.Product;
import com.haaris.service.ConfirmServiceImpl;
import com.haaris.service.OptVerifier;
import com.haaris.service.ProductServiceImpl;
import com.haaris.service.UserServiceImpl;
import com.haaris.service.WishlistServiceImpl;
import com.haaris.service.invoiceGenerator;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import net.sf.jasperreports.engine.JRException;

import com.haaris.model.WishList;

@Controller
public class CartController {
	
    @Autowired
	private UserServiceImpl userimpl;
    
    @Autowired
    private ProductServiceImpl proimpl;
    
    @Autowired
    private WishlistServiceImpl wishimpl;
    
    @Autowired
    private ConfirmServiceImpl coimpl;
    
    @Autowired
    private OptVerifier otpver;
    
    int  inv=100001;
	@RequestMapping(value= {"/buy-{product_id}-{userId}-product"},method = RequestMethod.GET)
	public String addProductCart(ModelMap model,@PathVariable("userId") int userid,@PathVariable("product_id") int product_id) {
		 if(userid!=0) {
			 String add= wishimpl.addItem(product_id,userid);
			 if(add=="done") {
				 model.addAttribute("Success","product "+product_id+" has added Successfully");
				 model.addAttribute("userId",userid);
				  return "redirect:/wishlist-"+userid; 
				 }
				 else {
					 return "redirect:/login";
			 }
		 }
		 return "redirect:/signUp";
	}
	
	 @RequestMapping(value= {"/wishlist-{userId}"},method = RequestMethod.GET)
		public String showWishList(ModelMap model,@PathVariable("userId") int userid) {
			double Netamout=0;

		 if(userid!=0) {
			List<WishList> wishList=wishimpl.getWishList((int)userid,0);
			for(int i=0;i<wishList.size();i++) {
				Netamout+= wishList.get(i).getAmount();

			}
//			System.out.println(Netamout);
			model.addAttribute("netamount", Netamout);
			model.addAttribute("wishList",wishList);
			model.addAttribute("userId",userid);	

			return"wishlist";
		 }
		 else {return "redirect:/login"; }
		}
	 
	 @RequestMapping(value = {"/cofirm-{userId}-order"}, method = RequestMethod.GET) 
	  public String confirmOrder(@PathVariable("userId") long userId,ModelMap modelmap) {
			double Netamout=0;
			int qty=0;
			 if(userId!=0) {
				 List<WishList> wishList=wishimpl.getWishList((int)userId,0);
					for(int i=0;i<wishList.size();i++) {
						Netamout+= wishList.get(i).getAmount();
						qty+=wishList.get(i).getQty();
						long pid=wishList.get(i).getProductId();
						int qt =proimpl.getProductById(pid).getQty();
						int wqt=wishList.get(i).getQty();
						proimpl.updateQty((qt-wqt),pid);
					}if(wishList.isEmpty()) {
						return "redirect:/home";
					}
					else {
//					System.out.println(wishList.size()+"....."+inv);
					coimpl.addOrder(qty,Netamout , (int)userId,wishList,userimpl,"0",inv);
					wishimpl.updatecflag((int)userId, 1,"HRC"+inv,0);
					++inv;

					qty=0;Netamout=0;
					return "redirect:/thanks";
					}
					
					
			 }
			 else {
			return "redirect:/login";
			 }
	 }
	 
	 @PostMapping("/wishlist/Confirmor")
	 public ResponseEntity<?> updateOrder(@RequestBody Map<String,Object> data){
		 int user_id=(int) data.get("id");
		 double Netamout=0;
			int qty=0;
			 if(user_id!=0) {
				 List<WishList> wishList=wishimpl.getWishList((int)user_id,0);
					for(int i=0;i<wishList.size();i++) {
						Netamout+= wishList.get(i).getAmount();
						qty+=wishList.get(i).getQty();
						long pid=wishList.get(i).getProductId();
						int qt =proimpl.getProductById(pid).getQty();
						int wqt=wishList.get(i).getQty();
						proimpl.updateQty((qt-wqt),pid);
					}
					if(wishList.isEmpty()) {
						return null;
					}
					else {
					String payment_id=data.get("payment_id").toString();
					coimpl.addOrder(qty,Netamout , (int)user_id,wishList,userimpl,payment_id,inv);
					wishimpl.updatecflag((int)user_id, 1,"HRC"+inv,0);
					
					++inv;
					qty=0;Netamout=0;
					return ResponseEntity.ok(Map.of("msg","updated"));
					}
			 }else {
					return null;
 
			 }
	 }
	 
	 
	 
		@RequestMapping(value= {"/thanks"},method = RequestMethod.GET)
		public String thanks(ModelMap model) {
		return "thanks";
		}
		

	 @PostMapping("/wishlist/create_order")
		@ResponseBody
		public String createOrder(@RequestBody Map<String,Object> data) throws RazorpayException {
		 int user_id=(int) data.get("id");

			double amount=Double.parseDouble(data.get("amount").toString());
//			System.out.println(inv);
			 List<WishList> wishList=wishimpl.getWishList((int)user_id,0);
			 	if(wishList!=null) {
				var client= new RazorpayClient("<<Razorpay Id>>","<<Secret Key>>");
				JSONObject options = new JSONObject();
				options.put("amount", amount*100);
				options.put("currency", "INR");
				options.put("receipt","HRC"+"/"+user_id+"/"+inv);
				Order od=client.Orders.create( options);
//				System.out.println(od);
				return od.toString();
			 	}else {
				 	return "redirect:/home";

			 	}

			
			
		}
		@RequestMapping(value= {"/delete-{product_id}-{userId}-list"},method = RequestMethod.GET)
		public String deleteProductCart(ModelMap model,@PathVariable("product_id") int product_id,@PathVariable("userId") int userid) {
			 if(userid!=0) {
				 wishimpl.deleteItem(userid, product_id);
				 return "redirect:/wishlist-"+userid;
			 }
			 else {
			 return "redirect:/login";
			 }
		}
		
		@RequestMapping(value= {"/order-{userId}"},method = RequestMethod.GET)
		public String displayHistory(ModelMap model,@PathVariable("userId") int user_id) {
			if(user_id!=0) {
				List<WishList> wishList=wishimpl.getWishList((int)user_id,2);
				List<WishList> wishList2=wishimpl.getWishList((int)user_id,3);
				List<WishList> wishList3=wishimpl.getWishList((int)user_id,4);
				wishList.addAll(wishList2);
				wishList.addAll(wishList3);
				model.addAttribute("wishList",wishList);
				model.addAttribute("userId",user_id);	
			return "orderhistory";
			}
			else {
				return "redirect:/login";
			}
		}
		
		@RequestMapping(value= {"/incre-{productId}-{userId}"},method = RequestMethod.GET)
		public String incrementQty(ModelMap model,@PathVariable("productId") int productId,@PathVariable("userId") int user_id) {
			if(user_id!=0) {
				wishimpl.updateItem(productId, user_id, productId, 0);
				model.addAttribute("userId",user_id);	
			return "redirect:/wishlist-"+user_id;
			}
			else {
				return "redirect:/login";
			}
		}
		
		@RequestMapping(value= {"/dec-{productId}-{userId}"},method = RequestMethod.GET)
		public String decrementQty(ModelMap model,@PathVariable("productId") int productId,@PathVariable("userId") int user_id) {
			if(user_id!=0) {
				wishimpl.updateItem(productId, user_id, productId, 1);
				model.addAttribute("userId",user_id);	
			return "redirect:/wishlist-"+user_id;
			}
			else {
				return "redirect:/login";
			}
		}
	  
	
}
