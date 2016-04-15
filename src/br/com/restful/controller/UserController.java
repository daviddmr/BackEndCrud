package br.com.restful.controller;

import java.util.List;

import br.com.restful.dao.UserDAO;
import br.com.restful.model.User;
import br.com.restful.model.Users;

public class UserController {

	public List<User> selectAll(){
		System.out.println("Get All Users");
//		return UserDAO.getInstance().selectAll();
		return UserDAO.getInstance().selectAllJPA();
	}
	
	public User selectOne(int id){
		System.out.println("Get one user");
//		return UserDAO.getInstance().selectOne(id);
		return UserDAO.getInstance().selectOneJPA(id);
	}
	
	public User addUser(User user) {
		System.out.println("Add user");
//		return UserDAO.getInstance().insert(user);
		return UserDAO.getInstance().insertJPA(user);
	}
	
	public User updateUser(User user){
		System.out.println("Update user");
//		return UserDAO.getInstance().updateUser(user); 
		return UserDAO.getInstance().updateUserJPA(user);
	}
	
	public User deleteUser(User user){
		System.out.println("Delete user");
//		return UserDAO.getInstance().deleteUser(user);
		return UserDAO.getInstance().deleteUserJPA(user);
	}
	
	public Users deleteMultipleUsers(Users users){
		return UserDAO.getInstance().deleteMultipleUsersJPA(users);
	}
}
