package com.example.item.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.commons.domain.entity.Product;

@FeignClient(name = "servicio.productos")
public interface ClientProductRest {
	
	@GetMapping("/getAll")
	public List<Product> getProducts();
	
	@GetMapping("/get/{id}")
	public Product getProduct(@PathVariable("id") Long id);
	

	@PostMapping("/create")
	public Product create(@RequestBody Product product);
	
	@PutMapping("/update/{id}")
	public Product update(@RequestBody Product product, @PathVariable("id") Long id);
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id);
	

}
