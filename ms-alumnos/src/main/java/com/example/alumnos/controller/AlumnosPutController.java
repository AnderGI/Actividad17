package com.example.alumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.alumnos.model.Alumno;
import com.example.alumnos.service.AlumnosService;

@RestController
public class AlumnosPutController {
	@Autowired
	private AlumnosService servicio;
	@PutMapping(path = "/alumnos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alumno> modificarAlumno(@RequestBody Alumno alumno, @PathVariable Integer id){
		alumno.setId(id);
		Alumno modificado = servicio.modificarAlumno(alumno);
		if(alumno == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(alumno);
	}
}
