package com.dev.bbs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dev.bss.beans.Booking;
import com.dev.bss.beans.Bus;
import com.dev.bss.beans.Ticket;
import com.dev.bss.beans.User;
import com.dev.bss.sevice.ServiceUser;

@Controller
public class BookingController {
	@Autowired
	Ticket ticket;
	@Autowired
	User user;
	
	@Autowired
	ServiceUser services;
@GetMapping("/book")
 public String getBook()
 {
	 return "book";
 }

@PostMapping("/book")
public ModelAndView book(HttpServletRequest req,ModelAndView mv)
{
	
	try {
//		Integer userId = Integer.parseInt(req.getParameter("userId"));
		System.out.println(user.getUserId());
		ticket.setUserId(user.getUserId());
		String source = req.getParameter("source");
		String destination = req.getParameter("destination");
		String date2 = req.getParameter("date");
		ticket.setSource(source);
		ticket.setDestination(destination);
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
		java.sql.Date date = new java.sql.Date(date1.getTime());
		ticket.setDate(date1);
		List<Bus> buses = services.searchBus(source, destination, date);
		mv.addObject("buses", buses);
		mv.setViewName("buses");
		return mv;
	} catch (ParseException e) {
		e.printStackTrace();
	}
	
	
	return mv;
	
}
@PostMapping("/select")
public ModelAndView select(HttpServletRequest req,ModelAndView mv)
{
	int busId = Integer.parseInt(req.getParameter("busId"));
	Integer numberSeats = Integer.parseInt(req.getParameter("number"));
	ticket.setBusId(busId);
	ticket.setNumberOfSeats(numberSeats);
	java.sql.Date date = new java.sql.Date(ticket.getDate().getTime());
	int available = services.checkAvailability(busId,date );
	ticket.setAvailable(available);
	if(available >= numberSeats)
	{
		Booking booking = services.bookTicket(ticket);
		mv.addObject("msg", booking);
		mv.setViewName("msg");
		return mv;
	}
	
	
	return mv;
	
}
@GetMapping("/view")
public String getview()
{
	 return "viewTicket";
}

@PostMapping("/view")
public ModelAndView getTicket(HttpServletRequest req , ModelAndView mv)
{
	Integer bookingId = Integer.parseInt(req.getParameter("bookingId"));
	Booking booking = services.getTicket(bookingId);
	if(booking != null)
	{
		mv.addObject("msg", booking);
		mv.setViewName("msg");
		return mv;
	}
	return mv;
}

@GetMapping("/cancel")
public String getTicketPage()
{
	return "cancel";
}

@PostMapping("/cancel")
public ModelAndView cancelTicket(HttpServletRequest req , ModelAndView mv)
{
	Integer bookingId = Integer.parseInt(req.getParameter("bookingId"));
	Boolean booking = services.cancelTicket(bookingId);
	if(booking.equals(true))
	{
		mv.addObject("msg", "Ticket Cancelled");
		mv.setViewName("msg");
		return mv;
	}
	return mv;
}

}
