package com.elazzouzi.taxiapp.service;

import com.elazzouzi.taxiapp.model.Passenger;

public interface PassengerService {
	
	public Passenger findByUserName(String username);
	
	public Passenger findByEmail(String email);
	
	public Passenger findByPhoneNumber(String phoneNumber);

	public Passenger create(Passenger passenger);

	public void update(Passenger passenger);
}
