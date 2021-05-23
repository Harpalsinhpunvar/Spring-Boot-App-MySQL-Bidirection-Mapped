package com.hp.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manufactured {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int manufacturedId;
	private String manufacutedCountry;
	
	@OneToMany(mappedBy = "manufactured")
	private List<Product> product;
	
	public int getManufacturedId() {
		return manufacturedId;
	}
	public void setManufacturedId(int manufacturedId) {
		this.manufacturedId = manufacturedId;
	}
	public String getManufacutedCountry() {
		return manufacutedCountry;
	}
	public void setManufacutedCountry(String manufacutedCountry) {
		this.manufacutedCountry = manufacutedCountry;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	public Manufactured(int manufacturedId, String manufacutedCountry, List<Product> product) {
		super();
		this.manufacturedId = manufacturedId;
		this.manufacutedCountry = manufacutedCountry;
		this.product = product;
	}
	public Manufactured() {
		super();
		// TODO Auto-generated constructor stub
	}

}
