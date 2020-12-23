package com.alis.stockservice.model.request;

import javax.validation.constraints.NotNull;

public class UserSaveRequest {
	@NotNull
	private String name;
	@NotNull
	private String password;
	@NotNull
	private Long phoneNumber;
	@NotNull
	private String phoneCode;
	@NotNull
	private String userType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public UserSaveRequest(@NotNull String name, @NotNull String password, @NotNull Long phoneNumber, @NotNull String phoneCode, @NotNull String userType) {
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.phoneCode = phoneCode;
		this.userType = userType;
	}
}
