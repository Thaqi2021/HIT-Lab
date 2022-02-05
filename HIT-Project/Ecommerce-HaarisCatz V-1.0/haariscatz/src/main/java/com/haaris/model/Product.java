package com.haaris.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="product")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long product_id;
	
    @NotEmpty
	private String hsncode;
    
	private String brand;
    
    @NotEmpty
    private String productName;
    //	@Transient
//	private File myImage;
	
	
    @Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String myImageObj;
    
	private int qty;
	
	private double price;
	
	private String pdesc;

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getHsncode() {
		return hsncode;
	}

	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMyImageObj() {
		return myImageObj;
	}

	public void setMyImageObj(String myImageObj) {
		this.myImageObj = myImageObj;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((hsncode == null) ? 0 : hsncode.hashCode());
		result = prime * result + ((myImageObj == null) ? 0 : myImageObj.hashCode());
		result = prime * result + ((pdesc == null) ? 0 : pdesc.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + (int) (product_id ^ (product_id >>> 32));
		result = prime * result + qty;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (hsncode == null) {
			if (other.hsncode != null)
				return false;
		} else if (!hsncode.equals(other.hsncode))
			return false;
		if (myImageObj == null) {
			if (other.myImageObj != null)
				return false;
		} else if (!myImageObj.equals(other.myImageObj))
			return false;
		if (pdesc == null) {
			if (other.pdesc != null)
				return false;
		} else if (!pdesc.equals(other.pdesc))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (product_id != other.product_id)
			return false;
		if (qty != other.qty)
			return false;
		return true;
	}
	
	
	
	
}
