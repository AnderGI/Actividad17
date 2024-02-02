package com.example.alumnos.controller;





import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alumnos.model.Alumno;
import com.example.alumnos.service.AlumnosService;

@RestController
public class AlumnosPostController {
	
	@Autowired
	private AlumnosService servicio;
	
	@PostMapping(path = "/alumnos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alumno> nuevoAlumno(@RequestBody Alumno alumno) {
		Alumno nuevo = servicio.nuevoAlumno(alumno);
		URI uri = null;
		try {
			uri = new URI("/alumnos/" + nuevo.getId());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.created(uri).build();
		
	}
}
