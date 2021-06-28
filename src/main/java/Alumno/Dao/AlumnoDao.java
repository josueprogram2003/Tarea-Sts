package Alumno.Dao;

import java.util.List;

import Alumno.entity.Alumno;

public interface AlumnoDao {
	
	int create(Alumno a);
	int update(Alumno a);
	int delete(int idalum);
	Alumno read(int id);
	List<Alumno> readAll();
	
	}
