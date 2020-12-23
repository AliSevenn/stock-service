package com.alis.stockservice.model.request;

import java.util.List;

public class UserQueryRequest {
	private List<Long> userIds;
	private List<Long> phoneNumbers;

	public List<Long> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Long> userIds) {
		this.userIds = userIds;
	}

	public List<Long> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public UserQueryRequest(List<Long> userIds, List<Long> phoneNumbers) {
		this.userIds = userIds;
		this.phoneNumbers = phoneNumbers;
	}
}
