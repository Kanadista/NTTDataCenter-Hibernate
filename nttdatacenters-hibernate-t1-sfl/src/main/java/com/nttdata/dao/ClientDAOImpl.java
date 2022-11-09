package com.nttdata.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nttdata.persistence.Client;

@Repository
public class ClientDAOImpl extends BaseDAOImpl<Client> implements ClientDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Client> searchByNameAndLastName(final String clientName, final String lastName) {
		Session currentSession = entityManager.unwrap(Session.class);
		//currentSession.createQuery("FROM Client WHERE clientName = " + clientName + " AND lastname = " +lastName).list(); Esta línea falla increíblemente, por alguna razón da una excepción diciendo que no encuentra la columna llamada "Pedro" que es el valor del name que uso en el main para llamar en el método principal.
		
		final CriteriaBuilder cb = currentSession.getCriteriaBuilder();
		final CriteriaQuery<Client> cquery = cb.createQuery(Client.class);
		final Root<Client> rootC = cquery.from(Client.class);
		
		final Predicate pr1 = cb.like(rootC.get("clientName"), clientName);
		final Predicate pr2 = cb.like(rootC.get("lastName"), lastName);
		
		cquery.select(rootC).where(cb.and(pr1,pr2));
		return currentSession.createQuery(cquery).getResultList();
	}
	
	
}
