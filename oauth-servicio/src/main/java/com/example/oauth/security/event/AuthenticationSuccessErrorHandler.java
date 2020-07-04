package com.example.oauth.security.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.commons.users.domains.model.User;
import com.example.oauth.services.UserService;

import feign.FeignException;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {
	
	private final Logger LOG = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);
	
	@Autowired
	private UserService userService;

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		UserDetails user = (UserDetails)authentication.getPrincipal();
		LOG.info(String.format("Authentication OK: Welcome ", user.getUsername()));
		User userDB = userService.findByUsername(authentication.getName());
		
		if (userDB.getRetry() != null && userDB.getRetry() > 0) {
			userDB.setRetry(0);
			userService.update(userDB, userDB.getId());
		}
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		LOG.error(String.format("Error authenticacion ", exception.getMessage()));
		
		try {
			User user = userService.findByUsername(authentication.getName());
			if (user.getRetry() == null) {
				user.setRetry(0);
			}
			
			user.setRetry(user.getRetry()+1);
			LOG.info("Current Retry: " + user.getRetry());
			
			if (user.getRetry() >= 3) {
				LOG.error(String.format("The user %s was disabled due to exceeded the number of retry", user.getUser()));
				user.setEnable(false);
			}
			userService.update(user, user.getId());
			
		} catch (FeignException e) {
			LOG.error(String.format("The user does not exists in the system,", authentication.getName()));
		}
		
	}

}
