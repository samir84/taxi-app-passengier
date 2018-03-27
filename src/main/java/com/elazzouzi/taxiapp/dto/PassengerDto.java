package com.elazzouzi.taxiapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

public class PassengerDto {

	@NotNull
    @Size(min = 1, message = "{Size.userDto.username}")
	private String username;
	@NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
	@Email(message = "{message.badEmail}")
	@NotEmpty(message = "{NotEmpty.user.email}")
	private String email;
	@NotNull
    @Size(min = 1, message = "{Size.PassengerDto.phoneNumber}")
    @Pattern(regexp="(^$|[0-9]{10})" , message ="{message.PassengerDto.phoneNumber}")
    private String phoneNumber;

	@NotNull
    //@Pattern(regexp="(^$|[0-9]{10})" , message ="{message.PassengerDto.profileUrl}")
	@URL(message ="{message.PassengerDto.profileUrl}")
	private String profileUrl;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	
	
}
