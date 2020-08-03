//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.30 at 05:45:01 AM IST 
//


package com.wu.solargalaxyservice.galaxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MobileList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MobileList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="product_mobile_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productColor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="productVendorName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productInStock" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MobileList", propOrder = {
    "productMobileId",
    "productName",
    "productColor",
    "productPrice",
    "productVendorName",
    "productInStock"
})
public class MobileList {

    @XmlElement(name = "product_mobile_id")
    protected long productMobileId;
    @XmlElement(required = true)
    protected String productName;
    @XmlElement(required = true)
    protected String productColor;
    protected double productPrice;
    @XmlElement(required = true)
    protected String productVendorName;
    protected boolean productInStock;

    /**
     * Gets the value of the productMobileId property.
     * 
     */
    public long getProductMobileId() {
        return productMobileId;
    }

    /**
     * Sets the value of the productMobileId property.
     * 
     */
    public void setProductMobileId(long value) {
        this.productMobileId = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the productColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductColor() {
        return productColor;
    }

    /**
     * Sets the value of the productColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductColor(String value) {
        this.productColor = value;
    }

    /**
     * Gets the value of the productPrice property.
     * 
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * Sets the value of the productPrice property.
     * 
     */
    public void setProductPrice(double value) {
        this.productPrice = value;
    }

    /**
     * Gets the value of the productVendorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductVendorName() {
        return productVendorName;
    }

    /**
     * Sets the value of the productVendorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductVendorName(String value) {
        this.productVendorName = value;
    }

    /**
     * Gets the value of the productInStock property.
     * 
     */
    public boolean isProductInStock() {
        return productInStock;
    }

    /**
     * Sets the value of the productInStock property.
     * 
     */
    public void setProductInStock(boolean value) {
        this.productInStock = value;
    }

}
