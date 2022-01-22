package com.haariscart.service;



import java.util.List;

import com.haariscart.model.ConfirmOrder;
import com.haariscart.model.WishList;


public interface ConfirmService {
	ConfirmOrder addOrder(int qty,double amount,int cid ,List<WishList> list, UserServiceImpl userservice,String payment_id);
	
}
