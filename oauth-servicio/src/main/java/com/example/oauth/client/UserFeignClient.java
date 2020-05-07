package com.example.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.commons.users.domains.model.User;

@FeignClient(name = "servicio.usuarios")
public interface UserFeignClient {

	@GetMapping("/users/search/username")
	public User findByUser(@RequestParam("user") String user);
	
}
