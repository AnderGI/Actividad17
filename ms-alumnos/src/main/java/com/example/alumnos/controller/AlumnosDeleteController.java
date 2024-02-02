package com.example.alumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.alumnos.model.Alumno;
import com.example.alumnos.service.AlumnosService;

@RestController
public class AlumnosDeleteController {

	@Autowired
	private AlumnosService servicio;
	
	@DeleteMapping(name = "/alumnos/{id}")
	public ResponseEntity<?> eliminarAlumno(@PathVariable Integer id) {
		Alumno alumno = servicio.getAlumnoById(id);
		if(alumno == null) return ResponseEntity.notFound().build();
		servicio.eliminarAlumno(alumno);
		return ResponseEntity.accepted().build();
	}
}
