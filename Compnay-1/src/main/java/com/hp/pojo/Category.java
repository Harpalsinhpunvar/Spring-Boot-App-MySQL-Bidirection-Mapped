package com.hp.pojo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Category_products")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String categoryName;
	private String categoryDetaails;
	
	@OneToOne(mappedBy = "category")
	private Product product;

	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDetaails() {
		return categoryDetaails;
	}
	public void setCategoryDetaails(String categoryDetaails) {
		this.categoryDetaails = categoryDetaails;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public Category(int categoryId, String categoryName, String categoryDetaails, Product product) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDetaails = categoryDetaails;
		this.product = product;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
