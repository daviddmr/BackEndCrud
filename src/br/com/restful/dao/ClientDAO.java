package br.com.restful.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.restful.model.Client;

public class ClientDAO {

	EntityManagerFactory emf;
	EntityManager em;
	
	public ClientDAO(){
		emf = Persistence.createEntityManagerFactory("maindatabase");
		em = emf.createEntityManager();
	}
	
	public void salvar(Client client){
		em.getTransaction().begin();
		em.merge(client);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Client client){
		em.getTransaction().begin();
		em.remove(client);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> listAll(){
		em.getTransaction().begin();
		Query query = em.createQuery("select client from Client client");
		List<Client> clients = query.getResultList();
		em.getTransaction().commit();
		emf.close();
		return clients;
	}
	
}
