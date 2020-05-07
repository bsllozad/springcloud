package com.example.item.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.commons.domain.entity.Product;
import com.example.item.domain.model.Item;
import com.example.item.service.ItemService;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate restClient;

	@Override
	public List<Item> finAll() {
		List<Product> products = Arrays.asList(restClient.getForObject("http://servicio.productos/getAll", Product[].class));
		return products.stream().map(prod -> new Item(prod,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer amount) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Product product = restClient.getForObject("http://servicio.productos/get/{id}", Product.class, pathVariables);
		return new Item(product, amount);
	}

	@Override
	public Product save(Product product) {
		HttpEntity<Product> body = new HttpEntity<Product>(product);
		ResponseEntity<Product> response = restClient.exchange("http://servicio.productos/create", HttpMethod.POST, body, Product.class);
		return response.getBody();
	}

	@Override
	public Product update(Product product, Long id) {
		
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		
		HttpEntity<Product> body = new HttpEntity<Product>(product);
		ResponseEntity<Product> response = restClient.exchange("http://servicio.productos/update/{id}", HttpMethod.PUT, body, Product.class, pathVariables);
		return response.getBody();
	}

	@Override
	public void delete(Long id) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		restClient.delete("http://servicio.productos/delete/{id}", pathVariables);
	}

}
