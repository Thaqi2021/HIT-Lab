package com.haariscart.model;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
	private String PaymentId;
    @NotNull
	private double NetAmount;

    private int NoOfProduct;
	public int getNoOfProduct() {
		return NoOfProduct;
	}

	public void setNoOfProduct(int noOfProduct) {
		NoOfProduct = noOfProduct;
	}

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

	public void setBillDate(LocalDate date) {
		this.billDate = date;
	}

	public double getNetAmount() {
		return NetAmount;
	}

	public void setNetAmount(double netAmount) {
		NetAmount = netAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentId() {
		return PaymentId;
	}

	public void setPaymentId(String paymentId) {
		PaymentId = paymentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(NetAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + NoOfProduct;
		result = prime * result + ((PaymentId == null) ? 0 : PaymentId.hashCode());
		result = prime * result + ((billDate == null) ? 0 : billDate.hashCode());
		result = prime * result + (int) (cid ^ (cid >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invoiceId == null) ? 0 : invoiceId.hashCode());
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
		if (Double.doubleToLongBits(NetAmount) != Double.doubleToLongBits(other.NetAmount))
			return false;
		if (NoOfProduct != other.NoOfProduct)
			return false;
		if (PaymentId == null) {
			if (other.PaymentId != null)
				return false;
		} else if (!PaymentId.equals(other.PaymentId))
			return false;
		if (billDate == null) {
			if (other.billDate != null)
				return false;
		} else if (!billDate.equals(other.billDate))
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
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		return true;
	}

	

	


    
	
}
