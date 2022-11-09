package com.nttdata.dao;

import java.util.List;

import com.nttdata.persistence.Client;

public interface ClientDAO extends BaseDAO<Client> {
	
	/**
	 * Metodo que devuelve una lista de clientes con mismo un nombre y apellido.
	 * @param name
	 * @param lastName
	 * @return
	 */
	public List<Client> searchByNameAndLastName(final String name, final String lastName);

}
