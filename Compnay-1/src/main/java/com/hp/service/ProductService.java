package com.hp.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.pojo.Product;
import com.hp.pojo.ProductUtilities;
import com.hp.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo pr;
	
	
	public Product saveProduct(Product product) {
		
		for(ProductUtilities pu: product.getProductUtilities()) 
		{
			pu.setProduct(product);
		}
		product.setProductUtilities(product.getProductUtilities());
		
		return pr.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products){
		return pr.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return pr.findAll();
	}
	
	public Product getByIdProduct(int id) {
		return pr.findById(id).orElse(null);
	}
	
	public Product getByNameProduct(String name) {
		return pr.findByName(name);
	}
	
	public Product updateProduct(Product product) {
		Product extProduct = pr.findById(product.getId()).orElse(null);
		extProduct.setName(product.getName());
		extProduct.setModelNo(product.getModelNo());
		extProduct.setCategory(product.getCategory());
		return pr.save(extProduct);
	}
	
	public String deleteProduct(int id) {
		pr.deleteById(id);
		return "Delete Id and Product Name : " + id;
	}
	
	
	
	
	
}
