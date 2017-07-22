package com.srivastava.mvc.dto;

import java.util.ResourceBundle;

public class ProductDTO {
	private int id;
	private String name;
	private String descr;
	private String image;
	private double price;
	public ProductDTO(){
		
	}
	public ProductDTO(int id , String name , String desc, String image, double price){
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String imagePath = rb.getString("imagepath");
		this.id  = id;
		this.name = name;
		this.descr = desc;
		this.image = imagePath+image;
		this.price= price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
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
	

}
