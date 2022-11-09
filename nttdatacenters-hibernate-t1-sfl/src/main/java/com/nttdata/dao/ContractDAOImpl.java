package com.nttdata.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nttdata.persistence.Client;
import com.nttdata.persistence.Contract;

@Repository
public class ContractDAOImpl extends BaseDAOImpl<Contract> implements ContractDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Contract> getContractByClientId(int clientId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		final CriteriaBuilder cb = currentSession.getCriteriaBuilder();
		final CriteriaQuery<Contract> cquery = cb.createQuery(Contract.class);
		final Root<Contract> rootC = cquery.from(Contract.class);
		final Join<Contract,Client> cJoinC = rootC.join("client");
		
		final Predicate pr1 = cb.equal(cJoinC.getParent().get("clientId"),clientId);
		return currentSession.createQuery(cquery).getResultList();
	}

}
