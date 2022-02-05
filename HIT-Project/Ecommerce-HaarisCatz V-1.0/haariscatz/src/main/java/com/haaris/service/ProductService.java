package com.haaris.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.haaris.model.Product;

public interface ProductService {
	List<Product> showProduct();
	Product AddProduct(Product product,MultipartFile ImageFile);
	void deleteProduct(long productId);
	Product getProductById(long productId);
	Product updateProduct(Product user, long productid,MultipartFile ImageFile);
	void updateQty(int qty, long productid);

	
}
