package br.com.restful.util;

import br.com.restful.dao.ClientDAO;
import br.com.restful.model.Client;
import br.com.restful.model.User;

public class Test {

	public static void main(String[] args) {
		Client client = new Client();
		client.setName("Miss Hello");
		client.setAge(30);
		
//		User user = new User();
//		user.setFirstName("Primeiro nome");
//		user.setAddress("Rua Ministro");
//		user.setAddressComplement("Complemento");
//		user.setBirthday(null);
		
		
		ClientDAO clientDAO = new ClientDAO();
		clientDAO.salvar(client);
//		clientDAO.salvarUser(user);
		

	}

}
