package com.example.alumnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alumnos.model.Alumno;
import com.example.alumnos.repository.AlumnosRepository;

@Service
public class AlumnosService {

	@Autowired
	private AlumnosRepository alumnosRepository;
	
	public List<Alumno> getAlumnos() {
		return alumnosRepository.findAll();
	}
	
	public Alumno getAlumnoById(Integer id) {
		return alumnosRepository.findById(id).orElse(null);
	}
	
	public Alumno nuevoAlumno(Alumno alumno) {
		return alumnosRepository.save(alumno);
	}
	
	public void eliminarAlumno(Alumno alumno) {
		alumnosRepository.delete(alumno);
	}
	
	public Alumno modificarAlumno(Alumno alumno) {
		if(alumno.getId() == null) return null;
		return alumnosRepository.save(alumno);
	}
}
