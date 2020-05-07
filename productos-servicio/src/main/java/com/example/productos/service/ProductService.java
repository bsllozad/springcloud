package com.example.productos.service;

import java.util.List;

import com.example.commons.domain.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public Product findById(Long id);
	
	public Product save(Product product);
	
	public void deleteById(Long id);
	
}
