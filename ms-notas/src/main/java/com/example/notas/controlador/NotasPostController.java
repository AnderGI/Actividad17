package com.example.notas.controlador;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.notas.modelo.Notas;
import com.example.notas.service.NotasServicio;

@RestController
public class NotasPostController {
	@Autowired
	private NotasServicio servicio;
	@Autowired
	private RestTemplate rest;
	@PostMapping(path="/notas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Notas> nuevaNota(@RequestBody Notas nota){
		// Alumnos
		try {
		rest.getForEntity("http://alumnos/alumnos/{id}", Object.class, nota.getIdAlumno());
		}catch (HttpClientErrorException ex) {
			// TODO: handle exception
			return ResponseEntity.notFound().build();
		}
		// System.out.println(nota);
		// Modulos
		try {
		rest.getForEntity("http://modulos/modulos/{id}", Object.class, nota.getIdModulo());
		}catch (HttpClientErrorException ex) {
			// TODO: handle exception
			return ResponseEntity.notFound().build();
		}
		
		Notas nueva = servicio.nuevaNota(nota);
		URI location = null;
		try {
			location = new URI("/notas/" + nueva.getId());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.created(location).build();
		
	}
}
