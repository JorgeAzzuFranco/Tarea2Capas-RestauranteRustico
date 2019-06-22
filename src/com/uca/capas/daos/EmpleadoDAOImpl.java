package com.uca.capas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Empleado;

@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager em;
	
	@Override
	public List<Empleado> findAll(Integer codigoSuc) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.empleado where id_sucursal = :cs");
		Query query = em.createNativeQuery(sb.toString(), Empleado.class);
		query.setParameter("cs", codigoSuc);
		List<Empleado> resultSet = query.getResultList();
		return resultSet;		
	}

	@Override
	public Empleado findOne(Integer codigo) throws DataAccessException {
		Empleado empleado = em.find(Empleado.class, codigo);
		return empleado;
	}

	@Override
	public int insert(Empleado empleado) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
