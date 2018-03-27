package com.elazzouzi.taxiapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elazzouzi.taxiapp.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

	public Passenger findByUsername(String username);
	public Passenger findByEmail(String email);
	public Passenger findByPhoneNumber(String phoneNumber);
}
