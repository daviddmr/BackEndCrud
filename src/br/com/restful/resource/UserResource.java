package br.com.restful.resource;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import br.com.restful.controller.UserController;
import br.com.restful.model.User;

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
	public User addUser(
		@FormParam("first_name") String firstName,
		@FormParam("last_name") String lastName,
		@FormParam("birthday") String birthDay,
		@FormParam("address") String address,
		@FormParam("address_complement") String addressComplement,
		@FormParam("district") String district,
		@FormParam("telephone") String telephone,
		@FormParam("mobile_phone") String mobilePhone,
		@FormParam("rg") String rg,
		@FormParam("cpf") String cpf,
		@FormParam("state") String state,
		@FormParam("city") String city,
		@FormParam("postcode") String postcode
		) {

		return new UserController().addUser(
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
		
		/*return Response.status(200)
			.entity("{status: 200, message: 'addUser is called'}")
//			.entity("addUser is called, Name : " + ", Lastname : ")
			.build();*/

	}
	
	@POST
	@Path("/update")
	@Produces("application/json")
	public User updateUser(
			@FormParam("id") int id,
			@FormParam("first_name") String firstName,
			@FormParam("last_name") String lastName,
			@FormParam("birthday") String birthDay,
			@FormParam("address") String address,
			@FormParam("address_complement") String addressComplement,
			@FormParam("district") String district,
			@FormParam("telephone") String telephone,
			@FormParam("mobile_phone") String mobilePhone,
			@FormParam("rg") String rg,
			@FormParam("cpf") String cpf,
			@FormParam("state") String state,
			@FormParam("city") String city,
			@FormParam("postcode") String postcode
			) {
		
		System.out.println("Id = "+id);
		
		return new UserController().updateUser(id, firstName, lastName, birthDay, address, addressComplement, district, telephone, mobilePhone, rg, cpf, state, city, postcode);
	}
	
	@POST
	@Path("/delete")
	public int deleteUser(@FormParam("id") int id){
		System.out.println("Id para apagar = "+id);
		return new UserController().deleteUser(id);
	}
	
	@POST
	@Path("/deleteUsers")
	@Produces("application/json")
	public void deleteUserMultipleUsers(
			@QueryParam("ids") List<Integer> ids
		){
		
		System.out.println("id = "+ids.size());

//		return new UserController().deleteMultipleUsers(ids);
	}
	
}
