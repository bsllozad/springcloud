package com.example.item;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateCOnfig {

	@Bean("ProductRestClient")
	@LoadBalanced
	public RestTemplate recordRestTemplate() {
		return new RestTemplate();
	}
	
}
