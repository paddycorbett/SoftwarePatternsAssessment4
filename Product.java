package com.example.dit.resteasy;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	private String brand;
	private double price;
	private String category;
	private String productImageURL;
	
	
	public Product() 
	{
		
	}
	
	public Product(String title, String brand,double price,String category, String productImageURL) 
	{
		this.title = title;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.productImageURL = productImageURL;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getBrand() {
		return brand;
	}

	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public String getProductImageURL() {
		return productImageURL;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setProductImageURL(String productImageURL) {
		this.productImageURL = productImageURL;
	}
	

}
