package com.haariscart.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.haariscart.model.Product;

public interface ProductService {
	List<Product> showProduct();
	Product AddProduct(Product product,MultipartFile ImageFile);
	void deleteProduct(long productId);
	Product getProductById(long productId);
	Product updateProduct(Product user, long productid);
	void updateQty(int qty, long productid);

	
}
