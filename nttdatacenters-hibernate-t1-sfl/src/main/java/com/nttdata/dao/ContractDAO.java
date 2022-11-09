package com.nttdata.dao;

import java.util.List;

import com.nttdata.persistence.Contract;

public interface ContractDAO extends BaseDAO<Contract>{
	/**
	 * Metodo que devuelve todos los contratos de un cliente.
	 * @param clientId
	 * @return
	 */
	public List<Contract> getContractByClientId(final int clientId);
}
