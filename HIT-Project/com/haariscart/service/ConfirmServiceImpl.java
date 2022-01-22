package com.haariscart.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haariscart.model.ConfirmOrder;
import com.haariscart.model.WishList;
import com.haariscart.repository.ConfirmOrderRepository;
import com.haariscart.repository.WishListRepository;

@Service
public class ConfirmServiceImpl implements ConfirmService {
	@Autowired
	ConfirmOrderRepository corep;
	
	@Autowired
	WishListRepository werep;
	int i=10001;
    invoice in = new invoice();

	public ConfirmServiceImpl(ConfirmOrderRepository corep) {
		this.corep=corep;
	}
	@Override
	public ConfirmOrder addOrder(int qty,double amount,int cid,List<WishList> wishList, UserServiceImpl userservice, String payment_id) {
		// TODO Auto-generated method stub
		ConfirmOrder order = new ConfirmOrder();
		order.setCid(cid);
		order.setBillDate(LocalDate.now());
		order.setNoOfProduct(qty);
		if(payment_id!="0") {
			order.setPaymentMethod("Online");
		}
		else {
			order.setPaymentMethod("cash");
		}
		order.setPaymentId(payment_id);
		order.setNetAmount(amount);  //Gst  +((amount*order.getGst())/100)
		order.setInvoiceId("HRC-"+cid+"-"+i);
		++i;
	    corep.save(order);
		System.out.println(wishList.size()+".....");

		in.mainer(wishList,order.getInvoiceId(),userservice);
		return  null;

	}

}
