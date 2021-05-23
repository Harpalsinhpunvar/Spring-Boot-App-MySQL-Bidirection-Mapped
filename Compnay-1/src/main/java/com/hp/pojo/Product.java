package com.hp.pojo;


import java.util.List;


import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Product_Info")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Product_Id")
	private int id;
	@Column(name="Product_Name")
	private String name;
	@Column(name="Product_Model_No")
	private String modelNo;
	
/*	//--------------------Unidirectional---------------------------------------------------
	
	//--------------------------------------------------------------------one to one mapping
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id", referencedColumnName="categoryId")
	private Category category;
	
	//--------------------------------------------------------------------Many to one mapping
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="manufactured_id", referencedColumnName="manufacturedId")
	private Manufactured manufactured;

	//--------------------------------------------------------------------one to many mapping
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="products_id", referencedColumnName="Product_Id")
	private List<ProductUtilities> productUtilities;
	
	//--------------------------------------------------------------------many to many mapping
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Customer> customer;
*/
	
	//===========================================Bidirectional================================================
	
	//======================================================================================one to one mapping
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "category_id", referencedColumnName="categoryId")
	private Category category;
	
	//======================================================================================many to one mapping
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="manufactured_id", referencedColumnName="manufacturedId")
	private Manufactured manufactured;
	
	//======================================================================================one to many mapping

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product1")
	private List<ProductUtilities> productUtilities;
	
	
	//======================================================================================many to many mapping

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Customer> customer;
	



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

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public Manufactured getManufactured() {
		return manufactured;
	}

	public void setManufactured(Manufactured manufactured) {
		this.manufactured = manufactured;
	}
	

	@JsonManagedReference
	public List<ProductUtilities> getProductUtilities() {
		return productUtilities;
	}

	public void setProductUtilities(List<ProductUtilities> productUtilities) {
		this.productUtilities = productUtilities;
	}
	

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
	

	public Product(int id, String name, String modelNo, Category category, Manufactured manufactured,
			List<ProductUtilities> productUtilities, List<Customer> customer) {
		super();
		this.id = id;
		this.name = name;
		this.modelNo = modelNo;
		this.category = category;
		this.manufactured = manufactured;
		this.productUtilities = productUtilities;
		this.customer = customer;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
