package com.example.item.domain.model;

import java.io.Serializable;

import com.example.commons.domain.entity.Product;

import lombok.Data;

@Data
public class Item implements Serializable{
	
	private static final long serialVersionUID = -200316801825277655L;
	
	private Product product;
	private Integer amount;

	public Item(Product product, Integer amount) {
		this.product = product;
		this.amount = amount;
	}

	public Item() {
	}
	
	public Double getTotal() {
		return product.getPrice() * amount.doubleValue();
	}
	
	
}
