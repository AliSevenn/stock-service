package com.alis.stockservice.model.response;

import com.alis.stockservice.model.User;

public class UserSaveResponse extends User {

	private String name;
	private Long phoneNumber;
	private String phoneCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public UserSaveResponse(String name, Long phoneNumber, String phoneCode) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.phoneCode = phoneCode;
	}

	public UserSaveResponse() {
	}
}
