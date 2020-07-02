package com.example.oauth.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.commons.users.domains.model.Role;
import com.example.commons.users.domains.model.User;
import com.example.oauth.client.UserFeignClient;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{
	
	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserFeignClient client;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = client.findByUser(username);
		
		if (user == null ) {
			log.error("The username or password is incorrect");
			throw new UsernameNotFoundException("The username or password is incorrect");
		}
		
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getDescription()))
				.peek(authority -> log.info("Role: " +  authority.getAuthority()))
				.collect(Collectors.toList());
		
		log.info("Username: " +  username);
		return new org.springframework.security.core.userdetails.User(user.getUser(), user.getPassword(), user.getEnable(), 
				true, true, true, authorities);
	}

	@Override
	public User findByUsername(String userName) {
		return client.findByUser(userName);
	}

}
