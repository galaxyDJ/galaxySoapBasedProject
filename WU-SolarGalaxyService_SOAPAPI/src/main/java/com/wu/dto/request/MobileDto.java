package com.wu.dto.request;

import java.io.Serializable;

public class MobileDto implements Serializable {
	
	private static final long serialVersionUID = 7972058424264906031L;
	
	private Long    product_mobile_id;
	private String  productName;
	private String  productColor;
	private double  productPrice;
	private String  productVendorName;
	private boolean productInStock;
	
	public MobileDto() {
		
	}

	public MobileDto(Long product_mobile_id, String productName, String productColor, double productPrice,
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
		return "MobileDto [product_mobile_id=" + product_mobile_id + ", productName=" + productName + ", productColor="
				+ productColor + ", productPrice=" + productPrice + ", productVendorName=" + productVendorName
				+ ", productInStock=" + productInStock + "]";
	}
	
}
