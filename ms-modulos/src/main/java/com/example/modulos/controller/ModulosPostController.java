package com.example.modulos.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.modulos.modelo.Modulo;
import com.example.modulos.service.ModuloService;

@RestController
public class ModulosPostController {
	@Autowired
	private ModuloService servicio;
	
	@PostMapping(path = "/modulos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Modulo> nuevoModulo(@RequestBody Modulo modulo){
		Modulo nuevo = servicio.nuevoModulo(modulo);
		URI uri = null;
		try {
			uri = new URI("/modulos/" + nuevo.getId());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.created(uri).build();
		
	}
}
