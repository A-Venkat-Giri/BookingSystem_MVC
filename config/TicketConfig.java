package com.dev.bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dev.bss.beans.Ticket;
@Configuration
public class TicketConfig {
	@Bean("ticket")
	public Ticket getTicket()
	{
	  Ticket ticket = new Ticket();
	  return ticket;
	}

}
