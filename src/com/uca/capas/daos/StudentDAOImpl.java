package com.uca.capas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Student;
import com.uca.capas.domain.Usuario;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager em;
	
	@Override
	public List<Student> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.student");
		Query query = em.createNativeQuery(sb.toString(), Student.class);
		List<Student> resultSet = query.getResultList();
		return resultSet;
	}

	@Override
	public Student findOne(Integer code) throws DataAccessException {
		Student student = em.find(Student.class, code);
		return student;
	}

	@Override
	@Transactional
	public int save(Student s, Integer newRow) throws DataAccessException {
		try {
			if(newRow == 1) em.persist(s);
			else em.merge(s);
			em.flush();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public int delete(int s) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE * FROM public.student WHERE id_student = :s");
		Query query = em.createNativeQuery(sb.toString(), Student.class);
		query.setParameter("s",	s);
		int resultSet = (int) query.getFirstResult();
		return resultSet;
	}

}
