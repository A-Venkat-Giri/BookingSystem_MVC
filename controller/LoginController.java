package com.dev.bbs.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.bss.beans.Feedback;
import com.dev.bss.beans.User;
import com.dev.bss.sevice.ServiceUser;

@Controller

public class LoginController {

	@Autowired
	private ServiceUser service;
	@Autowired
	private User user;

	@GetMapping("/login")
	public String getLogin()
	{
		return "login";
	}
	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest req, ModelAndView mv)
	{
		
		Integer userId = Integer.parseInt(req.getParameter("userId"));
		user.setUserId(userId);
		String password = req.getParameter("password");
		Boolean state = service.loginUser(userId, password);
		if(state)
		{
			user = service.searchUser(userId);
			HttpSession session = req.getSession();
			System.out.println(user);
			session.setAttribute("details", user);
			mv.setViewName("redirect:./details");
			return mv;
		}

		mv.setViewName("redirect:./login");
		return mv;

	}
	@GetMapping("/details")
	public String showdetails()
	{
		return "details";
	}

	@GetMapping("/update")
	public String showUpdatePage()
	{
		return "update";
	}
	@PostMapping("/update")
	public ModelAndView update(HttpServletRequest req, ModelAndView mv)
	{

		long contact = Long.parseLong(req.getParameter("contact"));
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");
		String email = req.getParameter("email");
		String name = req.getParameter("userName");
		user.setUserId(user.getUserId());
		user.setUserName(name);
		user.setPassword(oldPassword);
		user.setContact(contact);
		user.setEmail(email);
		Boolean state = service.updateUser(user, oldPassword, newPassword);
		String msg = "Failed to Update";
		if(state)
		{

			msg = "Succesfully Updated";
			mv.addObject("msg",msg);
			mv.setViewName("msg");
			return mv;
		}

		mv.setViewName("msg");
		return mv;

	}
	@GetMapping("/msg")
	public String showmsg()
	{
		return "msg";
	}

	@GetMapping("/delete")
	public String getDelete()
	{
		return "delete";
	}

	@PostMapping("/delete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv)
	{
		
		String password = req.getParameter("password");
		Boolean state = service.deleteUser(user.getUserId(), password);
		if(state)
		{
			mv.setViewName("redirect:./home");
			return mv;
		}

		mv.setViewName("redirect:./delete");
		return mv;

	}

	@GetMapping("/get")
	public String getSearch()
	{
		return "search";
	}
	@RequestMapping(value="/get", method=RequestMethod.POST)
	public ModelAndView getUserById(HttpServletRequest req, 
			ModelAndView mv){
		Integer id = Integer.parseInt(req.getParameter("userId"));
		User user = service.searchUser(id);
		System.out.println(user);
		mv.addObject("msg", user); //req.setAttribute("user",user)
		mv.setViewName("msg");
		return mv;
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest req,ModelAndView mv,HttpServletResponse resp)
	{
		HttpSession session =  req.getSession(false);
		System.out.println(session);
		if(session != null)
		{
			Cookie cookies[] = req.getCookies();
			for(Cookie cookie : cookies)
			{
				if(cookie.getName().equals("JSESSIONID"))
				{
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					System.out.println(cookie);
					mv.addObject("home", cookie);
					mv.setViewName("home");
					break;
				}
			}
		}
		else
		{
			mv.setViewName("details");
		}
		return mv;
	}
	@GetMapping("/feedback")
	public String getfeedback()
	{
		return "feedback";
	}
	@RequestMapping(value="/feedback", method=RequestMethod.POST)
	public ModelAndView getfeedback(HttpServletRequest req, ModelAndView mv){
		String userFeedback = req.getParameter("fb");
		Feedback feedback = new Feedback();
		feedback.setUserId(user.getUserId());
		feedback.setFeedback(userFeedback);
		Boolean b = service.giveFeedBack(feedback);
		if(b)
		{
		mv.addObject("msg", "SuccessFull"); //req.setAttribute("user",user)
		mv.setViewName("msg");
		return mv;
		}
		return mv;
	}
}