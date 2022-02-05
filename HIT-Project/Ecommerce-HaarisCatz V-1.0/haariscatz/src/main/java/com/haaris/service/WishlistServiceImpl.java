package com.haaris.service;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haaris.model.HaariUser;
import com.haaris.model.Product;
import com.haaris.model.WishList;
import com.haaris.repository.WishListRepository;

@Service
public class WishlistServiceImpl implements WishListService {
	Date dt = new Date();
	HaariUser user;
	WishList itemlist = new WishList();
	@Autowired
	ProductServiceImpl proimpl;
	@Autowired
	UserServiceImpl userimpl;
	@Autowired
	WishListRepository listrepo;
	int i=1;

	public WishlistServiceImpl(WishListRepository listrepo) {
		this.listrepo=listrepo;
	}
	
	@Override
	public String addItem(long product_id,long user_id) {
		Product product =	proimpl.getProductById(product_id);
//		System.out.println(product.getBrand()+"............."+user_id);
		HaariUser user =userimpl.getUserById(user_id);
		// TODO Auto-generated method stub
		if(user.getFlag()==1) {
			WishList checkQty =listrepo.getByproductId((int)user_id, product_id, 0);
			
			if(checkQty!=null) {
				i=checkQty.getQty();
				++i;
				checkQty.setQty(i);
				checkQty.setAmount(product.getPrice()*checkQty.getQty());
				listrepo.save(checkQty);
				return "done";
			}
			else {
		itemlist.setProductId(product.getProduct_id());
		itemlist.setCid((int)(long)user.getId());
		itemlist.setProductName(product.getProductName());
		itemlist.setDate(LocalDate.now());
		itemlist.setQty(1);
		itemlist.setCflag(0);
		itemlist.setQuno(product.getHsncode()+"/"+user.getId());
		itemlist.setAmount(product.getPrice()*itemlist.getQty());
//		System.out.println(product.getBrand()+".............");
		listrepo.save(itemlist);
		itemlist=new WishList();
		return "done";
			}
		}
		return "No";
	}

	@Override
	public WishList updateItem(long product_id, int cid,int cflag,int di) {
			WishList checkQty =listrepo.getByproductId(cid, product_id, 0);
			if(checkQty!=null) {
				double price =(checkQty.getAmount()/checkQty.getQty());
				if(di==0 ) {
				i=checkQty.getQty();
				++i;
				checkQty.setQty(i);
				checkQty.setAmount(price*checkQty.getQty());
				listrepo.save(checkQty);
				}
				else if(di==1) {
					if(checkQty.getQty()==1) {
						deleteItem((int)checkQty.getCid(),(int)checkQty.getProductId());
					}
					else if(checkQty.getQty()>0) {
					i=checkQty.getQty();
					--i;
					checkQty.setQty(i);
					checkQty.setAmount(price*checkQty.getQty());
					listrepo.save(checkQty);
					}
				}
			}
			return itemlist;
//		}
//		return itemlist;
	}



	@Override
	public List<WishList> getWishList(int cid,int cflag) {
		// TODO Auto-generated method stub
		List<WishList> wishList = listrepo.getByCid(cid,cflag);//9790682008
		return wishList;
	}
	
	@Override
	public List<WishList> getWishlistDetail(int cid,int cflag, String InvoiceId) {
		// TODO Auto-generated method stub
		List<WishList> wishList = listrepo.getByInvoiceId(cid,cflag,InvoiceId);//9790682008
		return wishList;
	}
	@Override
	public void updatecflag(int cid,int cflag,String orderId,int de ) {
		// TODO Auto-generated method stub
//		System.out.println(cflag+"................");
		if(de==0) {
		listrepo.updatecflag(cid, cflag,0);
		listrepo.updateOrderId(cid, cflag,orderId);
		listrepo.updatecflag(cid, 2,1);
		}
		else if(de==1) {
		listrepo.updatecflagByOrderId(cid, cflag,orderId);


		}
	}

	@Override
	public void deleteItem(int cid, int productid) {
		// TODO Auto-generated method stub
//		System.out.println(cid+"...."+productid);
		listrepo.deleteItem(cid,productid,0);
		
	}
	
	
	
	

}
