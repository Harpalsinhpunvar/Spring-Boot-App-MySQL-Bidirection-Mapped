package com.hp.pojo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ProductUtilities{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String utilitiesName;
	

	@ManyToOne
	@JoinColumn(name="product_id", referencedColumnName="Product_Id")
	private Product product1;
	
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUtilitiesName() {
		return utilitiesName;
	}
	public void setUtilitiesName(String utilitiesName) {
		this.utilitiesName = utilitiesName;
	}
	
	@JsonBackReference
	public Product getProduct() {
		return product1;
	}
	public void setProduct(Product product1) {
		this.product1 = product1;
	}
	
	public ProductUtilities(int id, String utilitiesName, Product product1) {
		super();
		this.id = id;
		this.utilitiesName = utilitiesName;
		this.product1 = product1;
	}
	public ProductUtilities() {
		super();
		// TODO Auto-generated constructor stub
	}
}