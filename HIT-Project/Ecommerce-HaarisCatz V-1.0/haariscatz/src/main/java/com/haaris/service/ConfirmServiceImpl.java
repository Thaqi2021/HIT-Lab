 package com.haaris.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haaris.model.ConfirmOrder;
import com.haaris.model.WishList;
import com.haaris.repository.ConfirmOrderRepository;
import com.haaris.repository.WishListRepository;

import net.sf.jasperreports.engine.JRException;

@Service
public class ConfirmServiceImpl implements ConfirmService {
	@Autowired
	ConfirmOrderRepository corep;
	
	@Autowired
	WishListRepository werep;
	
	@Autowired
    invoiceGenerator invoice;

	public ConfirmServiceImpl(ConfirmOrderRepository corep) {
		this.corep=corep;
	}
	@Override
	public ConfirmOrder addOrder(int qty,double amount,int cid,List<WishList> wishList, UserServiceImpl userservice, String payment_id,int invNo) {
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
		order.setInvoiceId("HRC"+invNo);
	    corep.save(order);
		try {
			invoice.downloadInvoice(wishList,order.getInvoiceId(),cid);
			
		} catch (JRException e) {e.printStackTrace();} catch (IOException e) {
			e.printStackTrace();
		}
		return  null;

	}
	@Override
	public List<ConfirmOrder> getAllOrder(int ccflag) {
				List<ConfirmOrder> orderList = corep.getAllOrder(ccflag);
				return 	orderList;


	}
	@Override
	public void updafeccflag(int cid, int ccflag, String invoiceId) {
		corep.updateccflag(cid,invoiceId, ccflag );
	}

}
