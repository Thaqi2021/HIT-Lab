package com.haaris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.haaris.model.Product;
import com.haaris.service.ConfirmServiceImpl;
import com.haaris.service.EmailSenderImpl;
import com.haaris.service.OptVerifier;
import com.haaris.service.ProductServiceImpl;
import com.haaris.service.UserServiceImpl;
import com.haaris.service.WishlistServiceImpl;
import com.haaris.model.HaariUser;

@Controller
@RequestMapping("/")
public class GeneralController {
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
    
	@RequestMapping(value= {"/","/home"},method = RequestMethod.GET)
	public String display(ModelMap model) {
		List<Product> product=proimpl.showProduct();
		model.addAttribute("product",product);
		model.addAttribute("userId",0);
	return "home";
	}
	@RequestMapping(value= {"/home-{userId}"},method = RequestMethod.GET)
	public String displayhome(ModelMap model,@PathVariable("userId") int userid) {
		List<Product> product=proimpl.showProduct();
		model.addAttribute("product",product);
		if(userid!=0) {model.addAttribute("userId",userid);}
		else {System.out.println("login");}
	return "home";
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
			if("exists".equals(finduser)) {
				return "redirect:/login";
			}else if(finduser.equals("new")) {
			  userimpl.saveUser(user);
			  EmailSenderImpl email = new EmailSenderImpl();
			  email.welcomeUser(user.getEmail());
			  modelMap.addAttribute("Success","HaariUser "+user.getName()+" has Register Successfully");
			  return "redirect:/login";
			}
			else {
				return "error";
			}
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
	 if(user.getEmail().equals("haariscart.dean@gmail.com")&&user.getPassword().equals("admin")) {
		 return"redirect:/admin";
	 }
	 else if(check=="No") {
		 return "redirect:/signUp";
		   }else if(check=="already login") {return "already login";}
	    else  {

	    	int user_id=Integer.parseInt(check);
//	    	System.out.println(user_id+"..........");
	    	modelMap.addAttribute("userId",user_id);
			 modelMap.addAttribute("Success","Logged in Successfully");
		    return "redirect:/home-"+user_id;
	    }
	  }
	
	@RequestMapping(value= {"/logout-{userId}"},method = RequestMethod.GET)
	public String logout(ModelMap model,@PathVariable("userId") int userid) {
//		System.out.println("im logout");
			String logoutR=userimpl.updateflag( userid,"logout");
//			System.out.println(logoutR+"...........");
			if(logoutR=="no") {
				model.addAttribute("userId",0);
			return "redirect:/home";
			}
			else {
				return "redirect:/home";

			}
	}
}
