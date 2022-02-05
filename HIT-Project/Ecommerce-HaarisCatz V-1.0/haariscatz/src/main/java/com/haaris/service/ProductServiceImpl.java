package com.haaris.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.ResourceNotFoundException;
import com.haaris.model.Product;
import com.haaris.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	ProductRepository prorep;
	
	public ProductServiceImpl(ProductRepository prorep) {
		// TODO Auto-generated constructor stub
		this.prorep=prorep;
	}
	@Override
	public List<Product> showProduct() {
		// TODO Auto-generated method stub
		return prorep.findAll();
	}

	@Override
	public Product AddProduct(Product product ,MultipartFile ImageFile) {
		// TODO Auto-generated method stub
		String fileName = StringUtils.cleanPath(ImageFile.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		
				
		try {
			product.setMyImageObj(Base64.getEncoder().encodeToString(ImageFile.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prorep.save(product);
	}

	@Override
	public void deleteProduct(long productId) {
		prorep.findById(productId).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "Id", productId));
		prorep.deleteById(productId);
		
	}



	@Override
	public Product updateProduct(Product product, long productid,MultipartFile ImageFile) {
		Product existingproduct =prorep.findById(productid).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", productid)); 
		
		existingproduct.setHsncode(product.getHsncode());
		existingproduct.setBrand(product.getBrand());
			if(ImageFile.isEmpty()!=true) {
			String fileName = StringUtils.cleanPath(ImageFile.getOriginalFilename());
			if(fileName.contains("..")) {
				System.out.println("not a valid file");
			}else{try {
				existingproduct.setMyImageObj(Base64.getEncoder().encodeToString(ImageFile.getBytes()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}}

		existingproduct.setQty(product.getQty());
		existingproduct.setPrice(product.getPrice());
		

		// save existing employee to DB
		prorep.save(existingproduct);
		return existingproduct;
	}
	@Override
	public Product getProductById(long productId) {
		Optional<Product> product =prorep.findById(productId);
		if(product.isPresent()) {
		return product.get();
		}
		return null;
	}
	@Override
	public void updateQty(int qty, long productid) {
		// TODO Auto-generated method stub
		prorep.updateQty(qty, productid);
	}

}
