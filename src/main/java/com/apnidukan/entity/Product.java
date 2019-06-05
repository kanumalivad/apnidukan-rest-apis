package com.apnidukan.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long productid;
	
	@Column(name="productname")
	String productname;
	
	@Column(name="stock")
	int stock;
	
	@Column(name="date")
	Date date;
	
	@Column(name="image")
	String image;
	
	@Column(name="price")
	double price;
	
	@Column(name="sellerid")
	long sellerid;
	
	@Column(name="brandid")
	long brandid;
	
	@Column(name="descriptionid")
	long descriptionid;
	
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getSellerid() {
		return sellerid;
	}
	public void setSellerid(long sellerid) {
		this.sellerid = sellerid;
	}
	public long getBrandid() {
		return brandid;
	}
	public void setBrandid(long brandid) {
		this.brandid = brandid;
	}
	public long getDescriptionid() {
		return descriptionid;
	}
	public void setDescriptionid(long descriptionid) {
		this.descriptionid = descriptionid;
	}
		
}
