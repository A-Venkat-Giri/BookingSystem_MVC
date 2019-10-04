package com.dev.bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dev.bss.beans.Bus;
@Configuration
public class BusConfig {
	
	@Bean("buses")
	public Bus getBus()
	{
		return new Bus();
	}

}
