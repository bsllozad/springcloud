package com.example.productos.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.commons.domain.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
