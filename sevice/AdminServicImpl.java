package com.dev.bss.sevice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.bss.beans.Available;
import com.dev.bss.beans.Bus;
import com.dev.bss.beans.Feedback;
import com.dev.bss.dao.DaoAdmin;
import com.dev.bss.dao.DaoAdminImpl;

@Service 
public class AdminServicImpl implements ServiceAdmin {
	DaoAdmin admin=new DaoAdminImpl();

	@Override
	public Bus createBus(Bus bus) {
		return admin.createBus(bus);
	}

	@Override
	public Boolean updateBus(Bus bus) {
		return admin.updateBus(bus);
	}

	@Override
	public Bus searchBus(int bus_id) {
		return admin.searchBus(bus_id);
	}

	@Override
	public Boolean deletebus(int bus_id, String password) {
		return admin.deletebus(bus_id, password);
	}

	@Override
	public List<Bus> busBetween(String source, String destination) {
		return admin.busBetween(source, destination);
	}

	@Override
	public Boolean adminLogin(int admin_id, String password) {
		return admin.adminLogin(admin_id, password);
	}

	@Override
	public Boolean addAvailability(Available available) {
		return admin.addAvailability(available);
	}

	@Override
	public List<Feedback> showFeedback() {
		return admin.showFeedback();
	}

	
}
