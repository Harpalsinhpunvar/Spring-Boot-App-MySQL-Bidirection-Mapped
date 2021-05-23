package com.hp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hp.pojo.Product;
import com.hp.service.ProductService;

@RestController
public class ProductController{
	
	@Autowired
	private ProductService ps;
	
	@PostMapping("/saveproduct")
	public Product postProduct(@RequestBody Product product) {
		return ps.saveProduct(product);
	}
	
	@PostMapping("/saveproducts")
	public List<Product> postProducts(@RequestBody List<Product> products){
		return ps.saveProducts(products);
	}
	
	@GetMapping("/getproducts")
	public List<Product> getProducts(){
		return ps.getProducts();
	}
	
	@GetMapping("/getproduct/{id}")
	public Product getProductId(@PathVariable ("id") int id){
		return ps.getByIdProduct(id);
	}
	
	@GetMapping("/getproductname/{name}")
	public Product getProductName(@PathVariable ("name") String name){
		return ps.getByNameProduct(name);
	}
	
	@PutMapping("/updateproduct/{id}")
	public Product updateProduct(@RequestBody Product product) {
		return ps.updateProduct(product);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable ("id") int id) {
		return ps.deleteProduct(id);	
	}
}