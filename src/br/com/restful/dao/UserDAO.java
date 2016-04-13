package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.ws.rs.core.Response;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.User;;

public class UserDAO extends ConnectionFactory{

	private static UserDAO instance;
	
	public static UserDAO getInstance(){
		if(instance == null)
			instance = new UserDAO();
		return instance;
	}
	
	public User insert(String firstName, String lastName, String birthDay, String address,
			String addressComplement, String district, String telephone, String mobilePhone, String rg, String cpf,
			String state, String city, String postcode) {
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		conexao = criarConexao();
		User user = new User();

		try {
			pstmt = conexao.prepareStatement(
					"insert into users(first_name, last_name, birthday,  address, address_complement, district, "
					+ "telephone, mobile_phone, rg, cpf, state, city, postcode) values(?, ?, ?, ?, ?, ?, ?, ?, "
					+ "?, ?, ?, ?, ?);"
					);
			
			user.setId(1);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setBirthday(birthDay);
			user.setAddress(address);
			user.setAddressComplement(addressComplement);
			user.setDistrict(district);
			user.setTelephone(telephone);
			user.setMobilePhone(mobilePhone);
			user.setRg(rg);
			user.setCpf(cpf);
			user.setState(state);
			user.setCity(city);
			user.setPostcode(postcode);
			
			pstmt.setString(1,firstName);
			pstmt.setString(2,lastName);
			pstmt.setString(3,birthDay);
			pstmt.setString(4,address);
			pstmt.setString(5,addressComplement);
			pstmt.setString(6,district);
			pstmt.setString(7,telephone);
			pstmt.setString(8,mobilePhone);
			pstmt.setString(9,rg);
			pstmt.setString(10,cpf);
			pstmt.setString(11,state);
			pstmt.setString(12,city);
			pstmt.setString(13,postcode);
			pstmt.execute();
			
		} catch (Exception e) {
			System.out.println("Erro ao adicionar o usuario: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return user;
	}
	
	public User updateUser(int id, String firstName, String lastName, String birthDay, String address,
			String addressComplement, String district, String telephone, String mobilePhone, String rg, String cpf,
			String state, String city, String postcode){
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conexao = criarConexao();
		User user = new User();

		try {
			pstmt = conexao.prepareStatement(
					"update users set first_name=?, last_name=?, birthday=?,  address=?, address_complement=?, "
					+ "district=?, telephone=?, mobile_phone=?, rg=?, cpf=?, state=?, city=?, postcode=? "
					+ "WHERE id = ?;"
					);
		
			user.setId(id);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setBirthday(birthDay);
			user.setAddress(address);
			user.setAddressComplement(addressComplement);
			user.setDistrict(district);
			user.setTelephone(telephone);
			user.setMobilePhone(mobilePhone);
			user.setRg(rg);
			user.setCpf(cpf);
			user.setState(state);
			user.setCity(city);
			user.setPostcode(postcode);
			
			pstmt.setString(1,firstName);
			pstmt.setString(2,lastName);
			pstmt.setString(3,birthDay);
			pstmt.setString(4,address);
			pstmt.setString(5,addressComplement);
			pstmt.setString(6,district);
			pstmt.setString(7,telephone);
			pstmt.setString(8,mobilePhone);
			pstmt.setString(9,rg);
			pstmt.setString(10,cpf);
			pstmt.setString(11,state);
			pstmt.setString(12,city);
			pstmt.setString(13,postcode);
            pstmt.setInt(14,id);
            pstmt.execute();
			
		} catch (Exception e) {
			System.out.println("Erro ao atualizar o usuario: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return user;	
	}
	
	public int deleteUser(int id) {
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();
		
		try {
			pstmt = conexao.prepareStatement(
					"DELETE FROM users WHERE id=?;"
					);
			pstmt.setInt(1,id);
			pstmt.execute();
			
		} catch (Exception e) {
			System.out.println("Erro ao apagar o usuario: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return id;
	}
	
	public User selectOne(int id){
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conexao = criarConexao();
		User user = new User();

		try {
			pstmt = conexao.prepareStatement("select * from users where id = '"+ id +"'");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setBirthday(rs.getString("birthday"));
				user.setAddress(rs.getString("address"));
				user.setAddressComplement(rs.getString("address_complement"));
				user.setDistrict(rs.getString("district"));
				user.setTelephone(rs.getString("telephone"));
				user.setMobilePhone(rs.getString("mobile_phone"));
				user.setRg(rs.getString("rg"));
				user.setCpf(rs.getString("cpf"));
				user.setState(rs.getString("state"));
				user.setCity(rs.getString("city"));
				user.setPostcode(rs.getString("postcode"));
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar o users: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return user;
	}

	public ArrayList<User> selectAll(){
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<User> users = null;
		
		conexao = criarConexao();
		users = new ArrayList<User>();
		try {
			pstmt = conexao.prepareStatement("select * from users order by id");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setBirthday(rs.getString("birthday"));
				user.setAddress(rs.getString("address"));
				user.setAddressComplement(rs.getString("address_complement"));
				user.setDistrict(rs.getString("district"));
				user.setTelephone(rs.getString("telephone"));
				user.setMobilePhone(rs.getString("mobile_phone"));
				user.setRg(rs.getString("rg"));
				user.setCpf(rs.getString("cpf"));
				user.setState(rs.getString("state"));
				user.setCity(rs.getString("city"));
				user.setPostcode(rs.getString("postcode"));
				users.add(user);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os users: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return users;
	}
	
	public void deleteMultipleUsers(){
		
	}

	
}
