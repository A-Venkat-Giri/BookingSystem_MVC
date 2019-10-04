package com.dev.bss.sevice;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.bss.beans.Booking;
import com.dev.bss.beans.Bus;
import com.dev.bss.beans.Feedback;
import com.dev.bss.beans.Ticket;
import com.dev.bss.beans.User;
import com.dev.bss.dao.DaoUser;
import com.dev.bss.dao.DaoUserImpl;
@Service  
public class UserServiceImpl implements ServiceUser {
	DaoUser dao=new DaoUserImpl();

	@Override
	public User createUser(User user) {
		return dao.createUser(user);
	}

	@Override
	public Boolean updateUser(User user, String password , String newPassword) {
		return dao.updateUser(user, password, newPassword);
	}

	@Override
	public Boolean deleteUser(int user_id, String password) {
		return dao.deleteUser(user_id, password);
	}

	@Override
	public Boolean loginUser(int user_id, String password) {
		return dao.loginUser(user_id, password);
	}

	@Override
	public User searchUser(int user_id) {
		return dao.searchUser(user_id);
	}

	@Override
	public Booking bookTicket(Ticket ticket) {
		return dao.bookTicket(ticket);
	}

	@Override
	public Boolean cancelTicket(int booking_id) {
		return dao.cancelTicket(booking_id);
	}

	@Override
	public Booking getTicket(int booking_id) {
		return dao.getTicket(booking_id);
	}

	@Override
	public Integer checkAvailability(int bus_id, Date date) {
		return dao.checkAvailability(bus_id, date);
	}

	@Override
	public List<Bus> searchBus(String source, String destination, Date date) {
		return dao.searchBus(source, destination, date);
	}

	@Override
	public List<Booking> getAllTickets(int userId) {
		return dao.getAllTickets(userId);
	}

	@Override
	public Boolean giveFeedBack(Feedback feedback) {
		return dao.giveFeedBack(feedback);
	}

}
