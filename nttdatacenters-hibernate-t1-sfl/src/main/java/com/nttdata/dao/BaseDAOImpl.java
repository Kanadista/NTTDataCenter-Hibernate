package com.nttdata.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.persistence.AbstractEntity;

/**
 * DAO base
 * @author Sebastián Forte
 *
 */
@Repository
public abstract class BaseDAOImpl<T extends AbstractEntity> implements BaseDAO<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Manejador de entidades */
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public BaseDAOImpl() {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Override
	@Transactional
	public void insert(final T paramT) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(paramT);
		currentSession.close();

	}

	@Override
	@Transactional
	public void update(final T paramT) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(paramT);
		currentSession.close();

	}

	@Override
	@Transactional
	public void delete(final T paramT) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.delete(paramT);
		currentSession.close();

	}

	@Override
	@Transactional
	public T findById(final int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		T result = currentSession.get(this.entityClass, id);
		currentSession.close();
		return result;

	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<T> getAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		List<T> list = currentSession.createQuery("FROM " + this.entityClass.getName()).list();
		currentSession.close();
		return list;

	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 *            the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
