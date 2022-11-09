package com.nttdata.dao;

import java.util.List;

public interface BaseDAO<T> {
	
	/**
	 * Inserta un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void insert(final T paramT);

	/**
	 * Actualiza un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void update(final T paramT);
	
	/**
	 * Elimina un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void delete(final T paramT);
	
	/**
	 * Localiza un registro por ID en BBDD.
	 * 
	 * @param paramT
	 */
	public T findById(final int id);

	/**
	 * Busqueda de todos los registros en BBDD.
	 * 
	 * @return List<T>
	 */
	public List<T> getAll();
 
}
