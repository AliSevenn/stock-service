package com.alis.stockservice.model.request;

import javax.validation.constraints.NotNull;

public class UserAddressSaveRequest {

	@NotNull
	private Long phoneNumber;
	@NotNull
	private Long regionId;
	@NotNull
	private String description;
	@NotNull
	private String country;

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public UserAddressSaveRequest(@NotNull Long phoneNumber, @NotNull Long regionId, @NotNull String description, @NotNull String country) {
		this.phoneNumber = phoneNumber;
		this.regionId = regionId;
		this.description = description;
		this.country = country;
	}
}
