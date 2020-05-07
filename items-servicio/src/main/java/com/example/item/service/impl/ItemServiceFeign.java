package com.example.item.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commons.domain.entity.Product;
import com.example.item.clients.ClientProductRest;
import com.example.item.domain.model.Item;
import com.example.item.service.ItemService;

@Service("serviceFeign")
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ClientProductRest clientProductRest;

	@Override
	public List<Item> finAll() {
		return clientProductRest.getProducts().stream().map(prod -> new Item(prod,1)).collect(Collectors.toList());
	}
	
	@Override
	public Item findById(Long id, Integer amount) {
		return new Item(clientProductRest.getProduct(id), amount);
	}


	@Override
	public Product save(Product product) {
		return clientProductRest.create(product);
	}

	@Override
	public void delete(Long id) {
		clientProductRest.delete(id);
	}
	
	@Override
	public Product update(Product product, Long id) {
		return clientProductRest.update(product, id);
	}

}
