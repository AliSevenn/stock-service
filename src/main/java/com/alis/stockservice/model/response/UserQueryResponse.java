package com.alis.stockservice.model.response;

import java.util.List;

import com.alis.stockservice.model.User;

public class UserQueryResponse {
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserQueryResponse(List<User> users) {
		this.users = users;
	}

	public UserQueryResponse() {
	}
}
