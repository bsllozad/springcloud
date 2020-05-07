package com.example.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.example.commons.domain.entity"})
public class ProductosServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosServicioApplication.class, args);
	}

}
