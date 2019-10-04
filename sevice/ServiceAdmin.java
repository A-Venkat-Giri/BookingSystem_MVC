package com.dev.bss.sevice;

import java.util.List;

import com.dev.bss.beans.Bus;
import com.dev.bss.beans.Feedback;

public interface ServiceAdmin {
	public Bus createBus(Bus bus);
	public Boolean updateBus(Bus bus);
	public Bus searchBus(int bus_id);
	public Boolean deletebus(int bus_id,String password);
	public List<Bus> busBetween(String source,String destination);
	public Boolean addAvailability(com.dev.bss.beans.Available available);
	
	
	public Boolean adminLogin(int admin_id, String password);
	public List<Feedback> showFeedback();
}
