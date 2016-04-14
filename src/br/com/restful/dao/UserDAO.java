package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.User;

public class UserDAO extends ConnectionFactory{

	private static UserDAO instance;
	
	static EntityManagerFactory emf;
	static EntityManager em;
	
	public static UserDAO getInstance(){
		if(instance == null)
//			emf = Persistence.createEntityManagerFactory("maindatabase");
//			em = emf.createEntityManager();
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
	
	public User insert(User user) {
//		try{
//			emf = Persistence.createEntityManagerFactory("maindatabase");
//			em = emf.createEntityManager();
//			em.getTransaction().begin();
//			em.merge(user);
//			em.getTransaction().commit();
//		}catch (Exception e) {
//			System.out.println("Erro ao adicionar o usuario: " + e);
//			e.printStackTrace();
//		}	finally {
//			emf.close();
//		}
//		return user;
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		conexao = criarConexao();
		
		try {
			pstmt = conexao.prepareStatement(
					"insert into users(first_name, last_name, birthday,  address, address_complement, district, "
					+ "telephone, mobile_phone, rg, cpf, state, city, postcode) values(?, ?, ?, ?, ?, ?, ?, ?, "
					+ "?, ?, ?, ?, ?);"
					);
			
			pstmt.setString(1,user.getFirstName());
			pstmt.setString(2,user.getLastName());
			pstmt.setString(3,user.getBirthday());
			pstmt.setString(4,user.getAddress());
			pstmt.setString(5,user.getAddressComplement());
			pstmt.setString(6,user.getDistrict());
			pstmt.setString(7,user.getTelephone());
			pstmt.setString(8,user.getMobilePhone());
			pstmt.setString(9,user.getRg());
			pstmt.setString(10,user.getCpf());
			pstmt.setString(11,user.getState());
			pstmt.setString(12,user.getCity());
			pstmt.setString(13,user.getPostcode());
			pstmt.execute();
			
		} catch (Exception e) {
			System.out.println("Erro ao adicionar o usuario: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return user;
	}
	
	public User updateUser(User user){
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();
		
		try {
			pstmt = conexao.prepareStatement(
					"update users set first_name=?, last_name=?, birthday=?,  address=?, address_complement=?, "
					+ "district=?, telephone=?, mobile_phone=?, rg=?, cpf=?, state=?, city=?, postcode=? "
					+ "WHERE id = ?;"
					);
			
			pstmt.setString(1,user.getFirstName());
			pstmt.setString(2,user.getLastName());
			pstmt.setString(3,user.getBirthday());
			pstmt.setString(4,user.getAddress());
			pstmt.setString(5,user.getAddressComplement());
			pstmt.setString(6,user.getDistrict());
			pstmt.setString(7,user.getTelephone());
			pstmt.setString(8,user.getMobilePhone());
			pstmt.setString(9,user.getRg());
			pstmt.setString(10,user.getCpf());
			pstmt.setString(11,user.getState());
			pstmt.setString(12,user.getCity());
			pstmt.setString(13,user.getPostcode());
			pstmt.setInt(14,user.getId());
            pstmt.execute();
			
		} catch (Exception e) {
			System.out.println("Erro ao atualizar o usuario: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return user;	
	}
	
	public User deleteUser(User user) {
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();
		
		try {
			pstmt = conexao.prepareStatement(
					"DELETE FROM users WHERE id=?;"
					);
			pstmt.setInt(1,user.getId());
			pstmt.execute();
			
		} catch (Exception e) {
			System.out.println("Erro ao apagar o usuario: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return user;
	}
	
	public List<Integer> deleteMultipleUsers(List<Integer> usersList) {
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();
		
		try{
			final Integer[] data = usersList.toArray(new Integer[usersList.size()]);
			final java.sql.Array sqlArray = conexao.createArrayOf("int4", data);
			
			pstmt = conexao.prepareStatement(
					"DELETE FROM users WHERE id in ?;"
					);
			
			pstmt.setArray(1, sqlArray);
			pstmt.execute();

		}catch(Exception e){
			System.out.println("Erro ao apagar os usuarios: "+e);
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return usersList;
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
