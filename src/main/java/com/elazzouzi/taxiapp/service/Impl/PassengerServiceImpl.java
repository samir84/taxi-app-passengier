package com.elazzouzi.taxiapp.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.elazzouzi.taxiapp.model.Passenger;
import com.elazzouzi.taxiapp.repository.PassengerRepository;
import com.elazzouzi.taxiapp.service.PassengerService;



@Service
public class PassengerServiceImpl implements PassengerService {

	//private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private PassengerRepository passengerRepository;

	
	@Override
	public Passenger findByUserName(String username) {
		return passengerRepository.findByUsername(username);
	}
	@Override
	public Passenger findByEmail(String email) {
		return passengerRepository.findByEmail(email);
	}
	@Override
	public Passenger findByPhoneNumber(String phoneNumber) {
		return passengerRepository.findByPhoneNumber(phoneNumber);
	}
	@Override
	public Passenger create(Passenger passenger) {
		Passenger existing = passengerRepository.findByUsername(passenger.getUsername());
		Assert.isNull(existing, "account already exists: " + passenger.getUsername());
		return passengerRepository.save(passenger);
	}
	@Override
	public void update(Passenger passenger) {
		Passenger existing = passengerRepository.findByUsername(passenger.getUsername());
		Assert.isNull(existing, "account already exists: " + passenger.getUsername());
		passengerRepository.save(passenger);
	}
	
	
}