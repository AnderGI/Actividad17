package com.example.modulos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.modulos.modelo.Modulo;
import com.example.modulos.service.ModuloService;

@RestController
public class ModulosPutController {

	@Autowired
	private ModuloService servicio;
	
	@PutMapping(path = "/modulos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Modulo> modificarModulo(@PathVariable Integer id, @RequestBody Modulo modulo) {
		modulo.setId(id);
		Modulo modificado = servicio.modificarModulo(modulo);
		if(modificado == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(modificado);
	}
}
