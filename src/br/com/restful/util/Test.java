package br.com.restful.util;

import br.com.restful.dao.ClientDAO;
import br.com.restful.model.Client;

public class Test {

	public static void main(String[] args) {
		Client client = new Client();
		client.setName("Miss Hello");
		client.setAge(30);
		
		ClientDAO clientDAO = new ClientDAO();
		clientDAO.salvar(client);

	}

}