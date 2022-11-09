package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.dao.ClientDAO;
import com.nttdata.persistence.Client;

@Service
public class ClientServiceImpl implements ClientServiceI {

	@Autowired
	private ClientDAO clientDAO;
	@Override
	public Client getClientById(int id) {
		return clientDAO.findById(id);
	}

	@Override
	public List<Client> getClientByNameAndLastName(String name, String lastName) {
		List<Client> clientList = new ArrayList<Client>();
		if(name != null && lastName != null) {
			clientList = clientDAO.searchByNameAndLastName(name, lastName);
		}
		return clientList;
	}

	@Override
	public void addClient(Client entity) {
		clientDAO.insert(entity);

	}

	@Override
	public void updateClient(Client entity) {
		clientDAO.update(entity);
	}

	@Override
	public void deleteClient(Client entity) {
		clientDAO.delete(entity);

	}

	@Override
	public List<Client> getAllClients() {
		return clientDAO.getAll();
	}

}
