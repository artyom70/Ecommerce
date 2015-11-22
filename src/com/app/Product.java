package com.app;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_desc")
	private String productDesc;
	@Column(name="product_image")
	private String productImage;
	@Column(name="product_image1")
	private String productImage1;
	@Column(name="product_image2")
	private String productImage2;
	@Column(name="product_image3")
	private String productImage3;
	@Column(name="product_image4")
	private String productImage4;
	@Column(name="price")
	private double price;
	@Column(name="product_size")
	private String productSize;
	@OneToOne
	@JoinColumn(name="cat_id")
	private Category category;
	
	public int getId() {
		return id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductImage1() {
		return productImage1;
	}
	public void setProductImage1(String productImage1) {
		this.productImage1 = productImage1;
	}
	public String getProductImage2() {
		return productImage2;
	}
	public void setProductImage2(String productImage2) {
		this.productImage2 = productImage2;
	}
	public String getProductImage3() {
		return productImage3;
	}
	public void setProductImage3(String productImage3) {
		this.productImage3 = productImage3;
	}
	public String getProductImage4() {
		return productImage4;
	}
	public void setProductImage4(String productImage4) {
		this.productImage4 = productImage4;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
