package com.example.item.service;

import java.util.List;

import com.example.commons.domain.entity.Product;
import com.example.item.domain.model.Item;

public interface ItemService {
	
	public List<Item> finAll();
	public Item findById(Long id, Integer amount);
	
	public Product save(Product product);
	
	public Product update(Product product, Long id);
	
	public void delete (Long id);
	
	

}
