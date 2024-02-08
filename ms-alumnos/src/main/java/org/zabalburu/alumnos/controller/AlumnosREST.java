package org.zabalburu.alumnos.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zabalburu.alumnos.modelo.Alumno;
import org.zabalburu.alumnos.service.AlumnosService;

@RestController
@RequestMapping("/alumnos")
public class AlumnosREST {
	@Autowired
	private AlumnosService service;
	
	@GetMapping("")
	public List<Alumno> getAlumnos(){
		return service.getAlumnos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getAlumno(@PathVariable Integer id){
		Alumno a = service.getAlumno(id);
		if (a == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(a);
	}
	
	@PostMapping
	public ResponseEntity<Alumno> nuevoAlumno(@RequestBody Alumno a) 
			throws URISyntaxException{
		a = service.nuevoAlumno(a);
		if (a == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.created(new URI("/alumnos/"+a.getId())).body(a);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Alumno> eliminarAlumno(@PathVariable Integer id){
		if (!service.eliminarAlumno(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Alumno> modificarAlumno(@PathVariable Integer id,
			@RequestBody Alumno a) {
		a.setId(id);
		a = service.modificarAlumno(a);
		if (a == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(a);
	}
}
