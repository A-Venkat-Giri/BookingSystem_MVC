package com.dev.bbs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
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

import com.dev.bss.beans.Admin;
import com.dev.bss.beans.Available;
import com.dev.bss.beans.Bus;
import com.dev.bss.beans.Feedback;
import com.dev.bss.beans.User;
import com.dev.bss.sevice.ServiceAdmin;

@Controller
public class AdminController {
	
	@Autowired
     ServiceAdmin services;
	
	@Autowired
	Bus buses;
	
	@GetMapping("/adminlogin")
	public String getLogin()
	{
		return "adminlogin";
	}
	@PostMapping("/adminlogin")
	public ModelAndView login(HttpServletRequest req, ModelAndView mv)
	{
		Admin admin = new Admin();
		Integer adminId = Integer.parseInt(req.getParameter("adminId"));
		String password = req.getParameter("password");
		System.out.println(adminId);
		Boolean state = services.adminLogin(adminId, password);
        
		if(state)
		{
			HttpSession session = req.getSession();
			admin.setAdminId(adminId);
			System.out.println(admin);
			session.setAttribute("detailsadmin", admin);
			mv.setViewName("redirect:./detailsadmin");
			return mv;
		}

		mv.setViewName("redirect:./adminlogin");
		return mv;

	}
	@GetMapping("/detailsadmin")
	public String showdetails()
	{
		return "detailsadmin";
	}

	
	@GetMapping("/updatebus")
	public String showUpdatePage()
	{
		return "updatebus";
	}
	@PostMapping("/updatebus")
	public ModelAndView update(HttpServletRequest req, ModelAndView mv)
	{

		Integer busId = Integer.parseInt(req.getParameter("busId"));
		String busName = req.getParameter("BusName");
		String source = req.getParameter("source");
		String destination = req.getParameter("destination");
		Integer price = Integer.parseInt(req.getParameter("price"));
		Integer seats = Integer.parseInt(req.getParameter("totalSeats"));
		Bus bus = new Bus();
		bus.setBusId(busId);
		bus.setBusName(busName);
		bus.setSource(source);
		bus.setDestination(destination);
		bus.setPrice(price);
		bus.setTotalSeats(seats);
		Boolean state = services.updateBus(bus);
		String msg = "Failed to Update";
		if(state)
		{

			msg = "Succesfully Updated";
			mv.addObject("msg1",msg);
			mv.setViewName("msg1");
			return mv;
		}

		mv.setViewName("msg1");
		return mv;

	}
	
	@GetMapping("/deletebus")
	public String getDelete()
	{
		return "deletebus";
	}

	@PostMapping("/deletebus")
	public ModelAndView deletebus(HttpServletRequest req, ModelAndView mv)
	{
		Integer busId = Integer.parseInt(req.getParameter("busId"));
		String password = req.getParameter("password");
		Boolean state = services.deletebus(busId, password);
		if(state)
		{
			mv.setViewName("redirect:./detailsadmin");
			return mv;
		}

		mv.setViewName("redirect:./deletebus");
		return mv;

	}
	
	@GetMapping("/getbus")
	public String getSearch()
	{
		return "getbus";
	}
	@RequestMapping(value="/getbus", method=RequestMethod.POST)
	public ModelAndView getUserById(HttpServletRequest req, 
			ModelAndView mv){
		Integer busId = Integer.parseInt(req.getParameter("busId"));
		Bus bus = services.searchBus(busId);
		System.out.println(bus);
		mv.addObject("msg1", bus); //req.setAttribute("user",user)
		mv.setViewName("msg1");
		return mv;
	}
	@GetMapping("/addbus")
	public String getAddbus()
	{
		return "addbus";
	}
	
	@RequestMapping(value= "/addbus",method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req , ModelAndView mv)
	{
		Bus bus = new Bus();
        bus.setBusName(req.getParameter("busName"));
        bus.setBusType(req.getParameter("busType"));
        bus.setSource(req.getParameter("source"));
        String destination = req.getParameter("destination");
        bus.setDestination(destination);
        bus.setPrice(Integer.parseInt(req.getParameter("price")));
        bus.setTotalSeats(Integer.parseInt(req.getParameter("totalSeats")));
		System.out.println(bus);
		buses = services.createBus(bus);
		System.out.println(buses);
		String msg ="Profile Creation Failed";
		if(bus!= null)
		{
		msg = "Profile Created Succesfull";
		mv.addObject("msg1", buses);
		mv.setViewName("available");
		return mv;
		}
		else
		{
			return mv;
		}
		
	}
	@GetMapping("/available")
	 public String getavail()
	 {
		 return "available";
	 }
	@PostMapping("/available")
	public ModelAndView getavail(HttpServletRequest req,ModelAndView mv)
	{
	
		
		try {
			int availSeats =Integer.parseInt( req.getParameter("seats"));
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date"));
			Available available = new Available();
			available.setAvailSeats(availSeats);
			available.setJourneyDate(date);
			available.setBusId(buses.getBusId());
			Boolean b = services.addAvailability(available);
			String str ="Failed to Add";
			if(b)
			{
				str = "Bus Added Succesfully";
				mv.addObject("msg",str);
				mv.setViewName("msg");
				return mv;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mv;
		
	}
	@GetMapping("/fbadmin")
	 public ModelAndView getfb(ModelAndView mv)
	 {
		List<Feedback> feedbacks = services.showFeedback();
		mv.addObject("msg1", feedbacks);
		mv.setViewName("msg1");
		 return mv;
	 }
	
	
	@GetMapping("/searchbus")
	 public String getBus()
	 {
		 return "searchbus";
	 }

	@PostMapping("/searchbus")
	public ModelAndView getBus(HttpServletRequest req,ModelAndView mv)
	{
		
		String source = req.getParameter("source");
		String destination = req.getParameter("destination");
		List<Bus> buses = services.busBetween(source, destination);
		mv.addObject("msg1", buses);
		mv.setViewName("msg1");
		return mv;
		
		
		
	}
	@GetMapping("/adminlogout")
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
			mv.setViewName("detailsadmin");
		}
		return mv;
	}

}
