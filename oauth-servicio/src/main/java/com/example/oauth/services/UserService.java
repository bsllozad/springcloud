package com.example.oauth.services;

import com.example.commons.users.domains.model.User;

public interface UserService {
	
	public User findByUsername(String userName);

}
