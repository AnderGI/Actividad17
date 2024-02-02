package com.example.alumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alumnos.model.Alumno;
import com.example.alumnos.service.AlumnosService;

import java.util.List;

@RestController
public class AlumnosGetController {
	@Autowired
	private AlumnosService servicio;
	@GetMapping("/alumnos")
	public ResponseEntity<List<Alumno>> getAlumnos(){
		return ResponseEntity.ok(servicio.getAlumnos());
	}
	@GetMapping("/alumnos/{id}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable Integer id) {
		Alumno alumno = servicio.getAlumnoById(id);
		if(alumno == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(alumno);
	}
}
