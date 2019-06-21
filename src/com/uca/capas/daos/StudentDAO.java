package com.uca.capas.daos;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Student;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.domain.Usuario;

public interface StudentDAO {
	List<Student> findAll() throws DataAccessException;
	Student findOne(Integer code) throws DataAccessException;
	int save(Student s, Integer newRow) throws DataAccessException;
	int delete(int s) throws DataAccessException;
}
