package br.com.restful.controller;

import java.util.ArrayList;
import java.util.List;
import java.sql.Array;

import javax.ws.rs.core.Response;

import br.com.restful.dao.UserDAO;
import br.com.restful.model.User;

public class UserController {

	public ArrayList<User> selectAll(){
		System.out.println("Get All Users");
		return UserDAO.getInstance().selectAll();
	}
	
	public User selectOne(int id){
		System.out.println("Get one user");
		return UserDAO.getInstance().selectOne(id);
	}
	
	public User addUser(String firstName, String lastName, String birthDay, String address,
			String addressComplement, String district, String telephone, String mobilePhone, String rg, String cpf,
			String state, String city, String postcode) {
		System.out.println("Add user");
		return UserDAO.getInstance().insert(
				firstName,
				lastName,
				birthDay,
				address,
				addressComplement,
				district,
				telephone,
				mobilePhone,
				rg,
				cpf,
				state,
				city,
				postcode
				);
	}	
	
	public User updateUser(int id, String firstName, String lastName, String birthDay, String address,
			String addressComplement, String district, String telephone, String mobilePhone, String rg, String cpf,
			String state, String city, String postcode){
		System.out.println("Update user");
		return UserDAO.getInstance().updateUser(id, firstName, lastName, birthDay, address, addressComplement, district, telephone, mobilePhone, rg, cpf, state, city, postcode); 
	}
	
	public int deleteUser(int id){
		return UserDAO.getInstance().deleteUser(id); 
	}
	
	public List<Integer> deleteMultipleUsers(List<Integer> idsToDelete){
		return UserDAO.getInstance().deleteMultipleUsers(idsToDelete);
	}
}
