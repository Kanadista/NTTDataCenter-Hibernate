package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Contract;

public interface ContractServiceI {
	/**
	 * Metodo que devuelve un contrato por su id.
	 * @param id
	 * @return
	 */
	Contract getContractById(int id);
	
	/**
	 * Metodo que devuelve todos los contratos de la BBDD.
	 * @return
	 */
	List<Contract> getAllContracts();
	
	/**
	 * Metodo que devuelve todos los contratos de un cliente.
	 * @param clientId
	 * @return
	 */
	List<Contract> getContractsByClientId(int clientId);
	
	/**
	 * Metodo que añade un contrato a la BBDD.
	 * @param entity
	 */
	void addContract(Contract entity);
	
	/**
	 * Metodo que actualiza un contrato de la BBDD.
	 * @param entity
	 */
	void updateContract(Contract entity);
	
	/**
	 * Metodo que borra un contrato de la BBDD.
	 * @param entity
	 */
	void deleteContract(Contract entity);
	
}
