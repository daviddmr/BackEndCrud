package br.com.restful.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.restful.controller.UserController;
import br.com.restful.model.User;
import br.com.restful.model.Users;

@Path("/user")
public class UserResource {
	
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public ArrayList<User> selectAll(){
		return new UserController().selectAll();
	}
	
	@GET
	@Path("/listarUm")
	@Produces("application/json")
	public User getUsers(
		@QueryParam("id") int id) {
		return new UserController().selectOne(id);
	}
	
	@POST
	@Path("/add")
	@Produces("application/json")
	@Consumes("application/json")
	public Response addUser(String userJson) {
		User user = null;
		User userResponse = null;
		if(userJson != null){
			try{
				user = new Gson().fromJson(userJson, User.class);
				userResponse = new UserController().addUser(user);
			}catch(Exception e){
				System.out.println("Erro: "+e);
			}
		}else{
			System.out.println("Json parameter is empty");
		}
		return Response.status(200)
			.entity("{\"status\": 200, \"message\":\""+userResponse.getFirstName()+ " adicionado com sucesso\"}")
			.build();
	}
	
	@POST
	@Path("/update")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateUser(String userJson) {
		
		User user = null;
		User userResponse = null;
		if(userJson != null){
			try{
				user = new Gson().fromJson(userJson, User.class);
				userResponse = new UserController().updateUser(user);
			}catch(Exception e){
				System.out.println("Erro: "+e);
			}
		}else{
			System.out.println("Json parameter is empty");
		}
		return Response.status(200)
			.entity("{\"status\": 200, \"message\":\""+userResponse.getFirstName()+ " alterado com sucesso\"}")
			.build();
	}
	
	@POST
	@Path("/delete")
	@Produces("application/json")
	@Consumes("application/json")
	public Response deleteUser(String userJson){
		User user = null;
		User userResponse = null;
		if(userJson != null){
			try{
				user = new Gson().fromJson(userJson, User.class);
				userResponse = new UserController().deleteUser(user);
			}catch(Exception e){
				System.out.println("Erro: "+e);
			}
		}else{
			System.out.println("Json parameter is empty");
		}
		
		return Response.status(200)
				.entity("{\"status\": 200, \"message\":\""+userResponse.getFirstName()+ " apagado com sucesso\"}")
				.build();
	}
	
	@POST
	@Path("/deleteUsers")
	@Produces("application/json")
	@Consumes("application/json")
	public Response deleteUserMultipleUsers(String usersJson){
		
		if(usersJson != null){
			System.out.println("teste = " + usersJson);
			try{
				Users users = new Gson().fromJson(usersJson, Users.class);
				List<Integer> userToDelete = new ArrayList<Integer>(); 
				for(User u: users.getListUsers()){
					System.out.println("Id = "+u.getId());
					userToDelete.add(u.getId());
				}
				new UserController().deleteMultipleUsers(userToDelete);
			}catch(Exception e){
				System.out.println("Erro: "+e);
			}
		}else{
			System.out.println("Json parameter is empty");
		}

		return Response.status(200)
//				.entity("{\"status\": 200, \"message\":\""+userResponse.getFirstName()+ " apagado com sucesso\"}")
				.entity("{\"status\": 200, \"message\":\""+" apagado com sucesso\"}")
				.build();
	}
}
