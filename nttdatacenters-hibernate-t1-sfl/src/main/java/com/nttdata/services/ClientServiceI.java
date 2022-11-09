package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Client;

public interface ClientServiceI {
	
	/**
	 * Metodo que devuelve un cliente por su id. 
	 * @param id
	 * @return
	 */
	Client getClientById(int id);
	
	/**
	 * Metodo que devuelve todos los clientes de la BBDD.
	 * @return
	 */
	List<Client> getAllClients();
	
	/**
	 * Metodo que devuelve todos los clientes con un mismo nombre y apellido.
	 * @param name
	 * @param lastName
	 * @return
	 */
	List<Client> getClientByNameAndLastName(String name, String lastName);
	
	/**
	 * Metodo que añade un cliente a la BBDD.
	 * @param entity
	 */
	void addClient(Client entity);
	
	/**
	 * Metodo que actualiza un cliente de la BBDD.
	 * @param entity
	 */
	void updateClient(Client entity);
	
	/**
	 * Metodo que borra un cliente de la BBDD.
	 * @param entity
	 */
	void deleteClient(Client entity);
	
}
