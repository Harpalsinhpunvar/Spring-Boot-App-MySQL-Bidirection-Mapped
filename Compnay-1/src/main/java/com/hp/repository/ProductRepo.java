package com.hp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hp.pojo.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	Product findByName(String name);

}
