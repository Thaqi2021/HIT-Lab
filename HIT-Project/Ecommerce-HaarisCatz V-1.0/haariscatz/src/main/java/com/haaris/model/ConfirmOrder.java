package com.haaris.model;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="ConfirmOrder")
public class ConfirmOrder implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//	@SequenceGenerator(name = "id",initialValue=1001)
	private Long id;
	
    @NotEmpty
	private String invoiceId; 
    
    private long cid;
    
    private LocalDate billDate;
    
	private String paymentMethod;
	
	@NotEmpty
	private String paymentId;
	
    @NotNull
	private double netAmount;
    
    @NotNull
    private int ccflag;

    private int NoOfProduct;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public int getCcflag() {
		return ccflag;
	}

	public void setCcflag(int ccflag) {
		this.ccflag = ccflag;
	}

	public int getNoOfProduct() {
		return NoOfProduct;
	}

	public void setNoOfProduct(int noOfProduct) {
		NoOfProduct = noOfProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + NoOfProduct;
		result = prime * result + ((billDate == null) ? 0 : billDate.hashCode());
		result = prime * result + ccflag;
		result = prime * result + (int) (cid ^ (cid >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invoiceId == null) ? 0 : invoiceId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((paymentId == null) ? 0 : paymentId.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
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
		ConfirmOrder other = (ConfirmOrder) obj;
		if (NoOfProduct != other.NoOfProduct)
			return false;
		if (billDate == null) {
			if (other.billDate != null)
				return false;
		} else if (!billDate.equals(other.billDate))
			return false;
		if (ccflag != other.ccflag)
			return false;
		if (cid != other.cid)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (invoiceId == null) {
			if (other.invoiceId != null)
				return false;
		} else if (!invoiceId.equals(other.invoiceId))
			return false;
		if (Double.doubleToLongBits(netAmount) != Double.doubleToLongBits(other.netAmount))
			return false;
		if (paymentId == null) {
			if (other.paymentId != null)
				return false;
		} else if (!paymentId.equals(other.paymentId))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		return true;
	}
    
	
	

	


    
	
}
