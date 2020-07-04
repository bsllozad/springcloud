package com.example.oauth.client;

//import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;

//import com.example.commons.users.domains.model.Role;
import com.example.commons.users.domains.model.User;

@FeignClient(name = "servicio.usuarios")
public interface UserFeignClient {

	@GetMapping("/users/search/username")
	public User findByUser(@RequestParam("user") String user);
	
	@PutMapping("/users/{id}")
	public User update(@RequestBody User user, @PathVariable("id") Long id);
	
////	@GetMapping("/users/{id}/roles")
//	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}/roles", consumes = "application/json")
//	public List<Role> getUserRoles(@RequestParam("id") Long id);
	
}
