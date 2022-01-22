package com.haariscart.service;

import java.util.List;

import com.haariscart.model.HaariUser;
import com.haariscart.model.Product;
import com.haariscart.model.WishList;

public interface WishListService {
	public String addItem(long product_id,long user_id);
	public WishList updateItem(Product productid,HaariUser cid,WishList wishlist);

	public void deleteItem(HaariUser cid,Product productid,WishList wishlist);
	List<WishList> getWishList(int cid,int cflag);
	
	public void updatecflag(int cid,int cflag);

}
