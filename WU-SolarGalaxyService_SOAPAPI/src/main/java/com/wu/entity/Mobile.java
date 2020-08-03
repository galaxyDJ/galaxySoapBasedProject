package com.wu.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="TBL_PRODUCT_MOBILE")
public class Mobile implements Serializable {
	
	@Id
	@GenericGenerator(name = "gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	@Column(name="PRODUCT_MOBILE_ID")
	private Long    product_mobile_id;
	@Column(name="PRODUCTNAME")
	private String  productName;
	@Column(name="PRODUCTCOLOR")
	private String  productColor;
	@Column(name="PRODUCTPRICE")
	private double  productPrice;
	@Column(name="PRODUCTVENDORNAME")
	private String  productVendorName;
	@Column(name="PRODUCTINSTOCK")
	@Type(type="yes_no")
	private boolean productInStock;
	
	public Mobile() {
		
	}

	public Mobile(Long product_mobile_id, String productName, String productColor, double productPrice,
			String productVendorName, boolean productInStock) {
		
		this.product_mobile_id = product_mobile_id;
		this.productName = productName;
		this.productColor = productColor;
		this.productPrice = productPrice;
		this.productVendorName = productVendorName;
		this.productInStock = productInStock;
		
	}

	public Long getProduct_mobile_id() {
		return product_mobile_id;
	}

	public void setProduct_mobile_id(Long product_mobile_id) {
		this.product_mobile_id = product_mobile_id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductVendorName() {
		return productVendorName;
	}

	public void setProductVendorName(String productVendorName) {
		this.productVendorName = productVendorName;
	}

	public boolean isProductInStock() {
		return productInStock;
	}

	public void setProductInStock(boolean productInStock) {
		this.productInStock = productInStock;
	}
	
	@Override
	public String toString() {
		return "Mobile [product_mobile_id=" + product_mobile_id + ", productName=" + productName + ", productColor="
				+ productColor + ", productPrice=" + productPrice + ", productVendorName=" + productVendorName
				+ ", productInStock=" + productInStock + "]";
	}
	
}
