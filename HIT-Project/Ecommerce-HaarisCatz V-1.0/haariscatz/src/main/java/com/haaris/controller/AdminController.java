package com.haaris.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.haaris.model.ConfirmOrder;
import com.haaris.model.HaariUser;
import com.haaris.model.Product;
import com.haaris.model.WishList;
import com.haaris.service.ConfirmServiceImpl;
import com.haaris.service.OptVerifier;
import com.haaris.service.ProductServiceImpl;
import com.haaris.service.UserServiceImpl;
import com.haaris.service.WishlistServiceImpl;

@Controller
public class AdminController {
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
	
	
	@RequestMapping(value= {"/admin"},method = RequestMethod.GET)
	public String display(ModelMap model) {	
	return "admin";
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
	 
	 @RequestMapping(value= {"/ProductList"},method = RequestMethod.GET)
		public String productList(ModelMap model) {
		 List<Product> product=proimpl.showProduct();
		 model.addAttribute("product",product);
				return "ProductList";
		}
	 
	 @RequestMapping(value= {"/edit-{product_id}-product"},method = RequestMethod.GET)
		public String editProduct(ModelMap model,@PathVariable("product_id") int id,Product product) {
		 product=proimpl.getProductById(id);
		 model.addAttribute("product",product);
		 return "addProduct";
		}
	 @RequestMapping(value= {"/edit-{product_id}-product"},method = RequestMethod.POST)
		public String Eproduct(ModelMap model,@PathVariable("product_id") int id,@RequestParam("myImage") MultipartFile imageFile,Product product) {
		 proimpl.updateProduct(product, id,imageFile);
		 model.addAttribute("product",product);
		 return "redirect:/ProductList";
		}
	 
	 @RequestMapping(value= {"/delete-{product_id}-product"},method = RequestMethod.GET)
		public String deleteProduct(ModelMap model,@PathVariable("product_id") int id) {
		 proimpl.deleteProduct(id);
		 return "redirect:/ProductList";
		}
	 
	 @RequestMapping(value= {"/showOrder"},method = RequestMethod.GET)
		public String checkOrder(ModelMap model) {
		 List<ConfirmOrder> order=coimpl.getAllOrder(0);
		 if(order.isEmpty()!=true) {
//		 System.out.println(order.get(0).getNetAmount());
		 model.addAttribute("order",order);

		 return "displayOrder";
		 }
		 else {
			 return "redirect:/thanks";
		 }
		}
	 @RequestMapping(value= {"/delivery-{cid}-{invoiceNo}-product"},method = RequestMethod.GET)
		public String detailOrder(ModelMap model,@PathVariable("cid") int cid, @PathVariable("invoiceNo") String invoiceNo) {
		HaariUser user =userimpl.getUserById(cid);
		 model.addAttribute("user",user);
		 List<WishList> list =wishimpl.getWishlistDetail(cid, 2,invoiceNo);
		 model.addAttribute("list",list);
		 model.addAttribute("invoiceNo",invoiceNo);
		 model.addAttribute("check", 1);

		 return "detailOrder";
		}
	 
	 @RequestMapping(value= {"/proceedToDelivery-{cid}-{invoiceNo}-ok"},method = RequestMethod.GET)
		public String proceedDelivery(ModelMap model,@PathVariable("cid") int cid, @PathVariable("invoiceNo") String invoiceNo) {
		 wishimpl.updatecflag(cid, 3, invoiceNo, 1);
		 coimpl.updafeccflag(cid, 1, invoiceNo);

		 return "redirect:/showOrder";
		}
	 
	 @RequestMapping(value= {"/displayDeliveryList"},method = RequestMethod.GET)
		public String checkDeliveryList(ModelMap model) {
		 
		 List<ConfirmOrder> order=coimpl.getAllOrder(1);
		 if(order.isEmpty()!=true) {
		 model.addAttribute("order",order);
		 model.addAttribute("check",0);
		 return "deliveryList";
		 }
		 else {
			 return "redirect:/thanks";
		 }
		}
	 
	 @RequestMapping(value= {"/delivery-{cid}-{invoiceNo}-done"},method = RequestMethod.GET)
		public String deliveryDone(ModelMap model,@PathVariable("cid") int cid, @PathVariable("invoiceNo") String invoiceNo) {
		HaariUser user =userimpl.getUserById(cid);
		 model.addAttribute("user",user);
		 List<WishList> list =wishimpl.getWishlistDetail(cid, 3,invoiceNo);
		 model.addAttribute("list",list);
		 model.addAttribute("invoiceNo",invoiceNo);
		 model.addAttribute("check", 0);
		 return "detailOrder";
		}
	 
	 @RequestMapping(value= {"/closeOrder-{cid}-{invoiceNo}-ok"},method = RequestMethod.GET)
		public String closeOrder(ModelMap model,@PathVariable("cid") int cid, @PathVariable("invoiceNo") String invoiceNo) {
		 wishimpl.updatecflag(cid, 4, invoiceNo, 1);
		 coimpl.updafeccflag(cid, 2, invoiceNo);

		 return "redirect:/displayDeliveryList";
		}
	 
////	 @RequestMapping(value= {"/getInvoice-{invoiceNo}"},method = RequestMethod.GET)
//		public String getInvoice(ModelMap model, @PathVariable("invoiceNo") String invoiceNo) {
//		System.out.println("im called....");
//		File invoice =new File("src\\main\\Data\\"+invoiceNo+".pdf");
//		model.addAttribute("invoice",invoice);
//		System.out.print(invoice.exists());
//		 return "invfile";
//		}
	 @RequestMapping(value= {"/getInvoice-{invoiceNo}"},method = RequestMethod.GET)
	    public void getInvoice(HttpServletResponse response, @PathVariable("invoiceNo") String invoiceNo) {
	        try {

	    		File invoice =new File("src\\main\\Data\\"+invoiceNo+".pdf");
	    		InputStream is =new FileInputStream(invoice);;
	            IOUtils.copy(is, response.getOutputStream());
	            response.setHeader("Content-Disposition", "attachment; filename="+invoiceNo+".pdf");
	            response.flushBuffer();
	        } catch (IOException ex) {
	            throw new RuntimeException("IOError writing file to output stream");
	        }
	    }
	 
	 @RequestMapping(value= {"/showClosedOrder"},method = RequestMethod.GET)
		public String ClosedOrder(ModelMap model) {
		 
		 List<ConfirmOrder> order=coimpl.getAllOrder(2);
		 if(order.isEmpty()!=true) {
		 model.addAttribute("order",order);
		 model.addAttribute("check",1);
		 return "deliveryList";
		 }
		 else {
			 return "redirect:/thanks";
		 }
		}

}
