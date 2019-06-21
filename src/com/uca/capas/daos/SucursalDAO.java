package com.uca.capas.daos;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Sucursal;

public interface SucursalDAO {
	public List<Sucursal> findAll() throws DataAccessException;
	public int insert(Sucursal sucursal) throws DataAccessException;
	public int delete(int id) throws DataAccessException;
	
}
