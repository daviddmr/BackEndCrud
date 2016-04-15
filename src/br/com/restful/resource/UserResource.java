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
	public Response selectAll(){
		String selectAllResponse = new Gson().toJson(new UserController().selectAll());
		return Response.status(200)
				.entity(selectAllResponse)
				.build();
	}
	
	@GET
	@Path("/listarUm")
	@Produces("application/json")
	public Response getUsers(
		@QueryParam("id") int id) {
		String selectOneResponse = new Gson().toJson(new UserController().selectOne(id));
		return Response.status(200)
				.entity(selectOneResponse)
				.build();
	}
	
	@POST
	@Path("/add")
	@Produces("application/json")
	@Consumes("application/json")
	public Response addUser(String userJson) {
		User user = null;
		String insertResponse = null;
		if(userJson != null){
			try{
				user = new Gson().fromJson(userJson, User.class);
				insertResponse = new Gson().toJson(new UserController().addUser(user));
			}catch(Exception e){
				System.out.println("Erro: "+e);
			}
		}else{
			System.out.println("Json parameter is empty");
		}
		return Response.status(200)
			.entity(insertResponse)
			.build();
	}
	
	@POST
	@Path("/update")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateUser(String userJson) {
		
		User user = null;
		String updateResponse = null;
		if(userJson != null){
			try{
				user = new Gson().fromJson(userJson, User.class);
				updateResponse = new Gson().toJson(new UserController().updateUser(user));
			}catch(Exception e){
				System.out.println("Erro: "+e);
			}
		}else{
			System.out.println("Json parameter is empty");
		}
		return Response.status(200)
			.entity(updateResponse)
			.build();
	}
	
	@POST
	@Path("/delete")
	@Produces("application/json")
	@Consumes("application/json")
	public Response deleteUser(String userJson){
		User user = null;
		String deleteResponse = null;
		if(userJson != null){
			try{
				user = new Gson().fromJson(userJson, User.class);
				deleteResponse = new Gson().toJson(new UserController().deleteUser(user));
			}catch(Exception e){
				System.out.println("Erro: "+e);
			}
		}else{
			System.out.println("Json parameter is empty");
		}
		
		return Response.status(200)
				.entity(deleteResponse)
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
					userToDelete.add((int) u.getId());
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
