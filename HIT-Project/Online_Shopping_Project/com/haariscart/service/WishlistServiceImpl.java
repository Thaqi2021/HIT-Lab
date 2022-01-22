package com.haariscart.service;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haariscart.model.HaariUser;
import com.haariscart.model.Product;
import com.haariscart.model.WishList;
import com.haariscart.repository.WishListRepository;

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
		System.out.println(product.getBrand()+"............."+user_id);
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
		System.out.println(product.getBrand()+".............");
		listrepo.save(itemlist);
		itemlist=new WishList();
		return "done";
			}
		}
		return "No";
	}

	@Override
	public WishList updateItem(Product products, HaariUser cid,WishList wishlist) {
//		Product product =	proimpl.getProductById(product_id);
//
//		if(user.getFlag()==1 && wishlist.getProductId()!=0) {
//			itemlist.setProductId((int)product.getProduct_id());
//			itemlist.setCid((int)(long)user.getId());
//			itemlist.setDate(LocalDate.now());
//			itemlist.setQty(itemlist.getQty());
//			itemlist.setAmount(products.getPrice()*itemlist.getQty());
			return itemlist;
//		}
//		return itemlist;
	}

	@Override
	public void deleteItem(HaariUser cid, Product productid,WishList wishlist) {
		if(user.getFlag()==1) {
			
		}		
	}

	@Override
	public List<WishList> getWishList(int cid,int cflag) {
		// TODO Auto-generated method stub
		List<WishList> wishList = listrepo.getByCid(cid,cflag);//9790682008
		return wishList;
	}

	@Override
	public void updatecflag(int cid,int cflag) {
		// TODO Auto-generated method stub
		listrepo.updatecflag(cid, cflag);
		
		
	}
	
	
	

}
