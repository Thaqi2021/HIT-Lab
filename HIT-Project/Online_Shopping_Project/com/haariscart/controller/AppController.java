package com.haariscart.controller;


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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.razorpay.*;

import com.haariscart.model.HaariUser;
import com.haariscart.model.Product;
import com.haariscart.model.WishList;
import com.haariscart.service.ConfirmServiceImpl;
import com.haariscart.service.OptVerifier;
import com.haariscart.service.ProductServiceImpl;
import com.haariscart.service.UserServiceImpl;
import com.haariscart.service.WishlistServiceImpl;


@Controller
@RequestMapping("/")
public class AppController {
    @Autowired
	private UserServiceImpl userimpl;
    
    private  long user_id;
    int i=10001;
    @Autowired
    private ProductServiceImpl proimpl;
    
    @Autowired
    private WishlistServiceImpl wishimpl;
    
    @Autowired
    private ConfirmServiceImpl coimpl;
    
    @Autowired
    private OptVerifier otpver;
	
//	@RequestMapping(value="sayhello4", method = RequestMethod.GET)
//	public String sayhello4(ModelMap model) {
//		System.out.println("im mapped with welcome jsp");
//		HaariUser user = new HaariUser();
//		model.addAttribute("user", user);
//		return "sigup1";
//		
//	}
//	 @RequestMapping(value = {"/sayhello4"}, method = RequestMethod.POST) 
//	  public String save1(HaariUser user, ModelMap modelMap) {
//		String finduser= userimpl.findUser(user);
//	if(finduser=="exists") {
//		return "redirect:/login";
//	}else {
//	  userimpl.saveUser(user);
//	  modelMap.addAttribute("Success","HaariUser "+user.getName()+" has Register Successfully");
//	  return "redirect:/login";
//	}
//	  }
	 
	 
	 
	 

	@RequestMapping(value= {"/","/home"},method = RequestMethod.GET)
	public String display(ModelMap model) {
		List<Product> product=proimpl.showProduct();
		model.addAttribute("product",product);	
		return"home";
	}
	@RequestMapping(value= {"/order"},method = RequestMethod.GET)
	public String displayHistory(ModelMap model) {
		if(user_id!=0) {
			List<WishList> wishList=wishimpl.getWishList((int)user_id,1);
			model.addAttribute("wishList",wishList);
			model.addAttribute("userId",user_id);	
		return "orderhistory";
		}
		else {
			return "redirect:/login";
		}
	}
	@RequestMapping(value="signUp",method = RequestMethod.GET)
	public ModelAndView showSingup(ModelAndView view) {
		ModelAndView mandv = new ModelAndView();
		HaariUser user = new HaariUser();
		mandv.addObject("user", user);
		mandv.setViewName("signUp");
		return mandv;
	}
	 @RequestMapping(value = {"/signUp"}, method = RequestMethod.POST) 
	  public String save(HaariUser user, ModelMap modelMap) {
		String finduser= new String(userimpl.findUser(user));
	if("exists"==finduser) {
		return "redirect:/login";
	}else {
//		String otpres =otpver.verifyMobileNo(user.getMobNo());
//		if(otpres=="success")
	  userimpl.saveUser(user);
	  modelMap.addAttribute("Success","HaariUser "+user.getName()+" has Register Successfully");
	  return "redirect:/login";
	}
	  }
	@RequestMapping(value="addProduct",method = RequestMethod.GET)
	public ModelAndView addProduct() {
		ModelAndView mandv = new ModelAndView();
		Product product = new Product();
		mandv.addObject("product", product);
		mandv.setViewName("addProduct");
		return mandv;
	}
	 @RequestMapping(value = {"/addProduct"}, method = RequestMethod.POST) 
	  public String saveProduct(@RequestParam("myImage") MultipartFile imageFile ,Product pro, ModelMap modelMap) {
		 if(imageFile!=null)
	  proimpl.AddProduct(pro,imageFile);
	  modelMap.addAttribute("Success","HaariUser "+pro.getHsncode() +" has Register Successfully");
	  return "redirect:/home"; 
	  }
	@RequestMapping(value="login",method = RequestMethod.GET)
	public ModelAndView showlogin(ModelAndView view) {
		ModelAndView mandv = new ModelAndView();
		HaariUser user = new HaariUser();
		mandv.addObject("user", user);
		mandv.setViewName("login");
		return mandv;
	}
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST) 
	  public String checkUser(HaariUser user, ModelMap modelMap) {

	 String check= userimpl.checkUser(user.getEmail(), user.getPassword());
	 if(check=="No") {
		 return "error";
		   }else if(check=="already login") {return "already login";}
	    else  {
	    	user_id=Integer.parseInt(check);
			 modelMap.addAttribute("Success","Logged in Successfully");
		    return "redirect:/home";
	    }
	  }
	
	 @RequestMapping(value = {"/buy-{product_id}-product"}, method = RequestMethod.GET) 
	  public String save(@PathVariable("product_id") long product_id,ModelMap modelmap) {
			 if(user_id!=0) {
				 String add= wishimpl.addItem(product_id,user_id);
				 if(add=="done") {
					  modelmap.addAttribute("Success","product "+product_id+" has added Successfully");
					  return "redirect:/wishlist"; 
					 }
					 else {
						 return "redirect:/login";
				 }
			 }
			 return "redirect:/signUp";
		 } 
	 
	 
	 @RequestMapping(value= {"/wishlist"},method = RequestMethod.GET)
		public String showWishList(ModelMap model) {
			double Netamout=0;

		 if(user_id!=0) {
			List<WishList> wishList=wishimpl.getWishList((int)user_id,0);
			for(int i=0;i<wishList.size();i++) {
				Netamout+= wishList.get(i).getAmount();

			}
			System.out.println(Netamout);
			model.addAttribute("netamount", Netamout);
			model.addAttribute("wishList",wishList);
			model.addAttribute("userId",user_id);	

			return"wishlist";
		 }
		 else {return "redirect:/login"; }
		}
	 @RequestMapping(value = {"/cofirm-{userId}-order"}, method = RequestMethod.GET) 
	  public String confirmOrder(@PathVariable("userId") long userId,ModelMap modelmap) {
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
					}if(wishList.isEmpty()) {
						return "redirect:/home";
					}
					else {
					System.out.println(wishList.size()+".....");
					coimpl.addOrder(qty,Netamout , (int)user_id,wishList,userimpl,"0");
					wishimpl.updatecflag((int)user_id, 1);
					
					qty=0;Netamout=0;
					return "redirect:/confirmorder";
					}
					
					
			 }
			 else {
			return "redirect:/login";
			 }
	 }
	 
	 @PostMapping("/wishlist/Confirmor")
	 public ResponseEntity<?> updateOrder(@RequestBody Map<String,Object> data){
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
					}if(wishList.isEmpty()) {
						return null;
					}
					else {
					System.out.println(wishList.size()+".....");
					String payment_id=data.get("payment_id").toString();
					coimpl.addOrder(qty,Netamout , (int)user_id,wishList,userimpl,payment_id);
					wishimpl.updatecflag((int)user_id, 1);
					
					qty=0;Netamout=0;
					return ResponseEntity.ok(Map.of("msg","updated"));
					}
			 }else {
					return null;
 
			 }
	 }
	 
	 
	 
		@RequestMapping(value= {"/confirmorder"},method = RequestMethod.GET)
		public String thanks(ModelMap model) {
//				
			return"confirmorder";
		}
		
		@PostMapping("/wishlist/create_order")
		@ResponseBody
		public String createOrder(@RequestBody Map<String,Object> data) throws RazorpayException {
			double amount=Double.parseDouble(data.get("amount").toString());
			System.out.println(data);
			 List<WishList> wishList=wishimpl.getWishList((int)user_id,0);
			 	if(wishList!=null) {
				var client= new RazorpayClient("rzp_test_T5KTnhikoHhbos","gJj5MqCCOZsXvWJiwniRKeNp");
				JSONObject options = new JSONObject();
				options.put("amount", amount*100);
				options.put("currency", "INR");
				options.put("receipt","HRC"+"/"+user_id+"/"+i);
				Order od=client.Orders.create( options);
				System.out.println(od);
				return od.toString();
			 	}else {
				 	return "redirect:/home";

			 	}

			
			
		}
	  

}
