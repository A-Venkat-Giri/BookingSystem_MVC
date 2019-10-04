package com.dev.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.bss.beans.User;
import com.dev.bss.sevice.ServiceUser;

@Controller
public class AddUserController {
	@Autowired
	User user;
	@Autowired
	ServiceUser services;

	@GetMapping("/add")
	public String getAddUser()
	{
		return "add";
	}

	@RequestMapping(value= "/add",method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req , ModelAndView mv)
	{
		user = new User();
		user.setEmail(req.getParameter("email"));
		user.setUserName(req.getParameter("userName"));
		user.setPassword(req.getParameter("password"));
		user.setContact(Long.parseLong(req.getParameter("contact")));
		System.out.println(user);
		user = services.createUser(user);
		System.out.println(user);
		String msg ="Profile Creation Failed";
		if(user!= null)
		{
			msg = "Profile Created Succesfull";
			mv.addObject("msg1", user);
			mv.setViewName("msg1");
			return mv;
		}
		else
		{
			return mv;
		}

	}

}
