package br.com.restful.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Users {
	
	@SerializedName("users")
	public List<User> listUsers;

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
}
