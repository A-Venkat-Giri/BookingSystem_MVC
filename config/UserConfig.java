package com.dev.bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dev.bss.beans.User;

@Configuration

public class UserConfig {
	@Bean("user")
	public User getUser()
	{
		
		User user = new User();
		return user;
	}

}
