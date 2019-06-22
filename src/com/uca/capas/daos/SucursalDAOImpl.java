package com.uca.capas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Sucursal;
import com.uca.capas.domain.Usuario;

@Repository
public class SucursalDAOImpl implements SucursalDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager em;

	@Override
	public List<Sucursal> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.sucursal");
		Query query = em.createNativeQuery(sb.toString(), Sucursal.class);
		List<Sucursal> sucursales = query.getResultList();
		return sucursales;
	}
	
	//No probada aun
	@Override
	public Sucursal findOne(Integer codigo) {
		Sucursal sucursal = em.find(Sucursal.class, codigo);
		return sucursal;
		
	}

	@Override
	public int insert(Sucursal sucursal) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
