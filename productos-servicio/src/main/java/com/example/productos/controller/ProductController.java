package com.example.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.commons.domain.entity.Product;
import com.example.productos.service.ProductService;

@RestController
public class ProductController {
	
	@Value("${server.port}")
	private Integer serverPort;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getAll")
	public List<Product> getAll(){
		return productService.findAll().stream().map(p -> {
			p.setPort(serverPort);
			return p;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/get/{id}")
	public Product getProduct(@PathVariable Long id) {
		Product product = productService.findById(id);
		product.setPort(serverPort);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return product;
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productService.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product update(@RequestBody Product product, @PathVariable Long id) {
		Product localProduct = productService.findById(id);
		if (localProduct != null) {
			localProduct.setName(product.getName());
			localProduct.setPrice(product.getPrice());
			return productService.save(localProduct);
		}
		
		return null;
	}

}
