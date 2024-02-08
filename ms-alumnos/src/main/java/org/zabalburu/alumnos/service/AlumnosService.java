package org.zabalburu.alumnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zabalburu.alumnos.modelo.Alumno;
import org.zabalburu.alumnos.repository.AlumnosRepository;

@Service
public class AlumnosService {

	@Autowired
	private AlumnosRepository dao;

	public List<Alumno> getAlumnos() {
		return dao.findAll();
	}

	public Alumno getAlumno(Integer id) {
		return dao.findById(id).orElse(null);
	}

	public Alumno nuevoAlumno(Alumno nuevo) {
		if (nuevo.getNombre() == null || nuevo.getApellidos() == null) {
			return null;
		}
		dao.save(nuevo);
		return nuevo;
	}

	public Alumno modificarAlumno(Alumno modificar) {
		/*
		 * dao.save(modificar); return modificar;
		 */
		Alumno a = getAlumno(modificar.getId());
		if (a != null) {
			if (modificar.getNombre() != null) {
				a.setNombre(modificar.getNombre());
			}
			if (modificar.getApellidos() != null) {
				a.setApellidos(modificar.getApellidos());
			}
			dao.save(a);
			return a;
		}
		return null;
	}

	public boolean eliminarAlumno(Integer id) {
		if (getAlumno(id) != null) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}

}
