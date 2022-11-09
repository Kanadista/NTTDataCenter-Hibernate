package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.dao.ContractDAO;
import com.nttdata.persistence.Contract;

@Service
public class ContractServiceImpl implements ContractServiceI {

	@Autowired
	private ContractDAO contractDAO;
	
	@Override
	public Contract getContractById(int id) {
		return contractDAO.findById(id);
	}

	@Override
	public List<Contract> getContractsByClientId(int clientId) {
		return contractDAO.getContractByClientId(clientId);
	}

	@Override
	public void addContract(Contract entity) {
		contractDAO.insert(entity);

	}

	@Override
	public void updateContract(Contract entity) {
		contractDAO.update(entity);

	}

	@Override
	public void deleteContract(Contract entity) {
		contractDAO.delete(entity);

	}

	@Override
	public List<Contract> getAllContracts() {
		return contractDAO.getAll();
	}

}
