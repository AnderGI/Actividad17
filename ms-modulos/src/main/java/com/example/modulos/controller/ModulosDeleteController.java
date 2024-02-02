package com.example.modulos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.modulos.modelo.Modulo;
import com.example.modulos.service.ModuloService;

public class ModulosDeleteController {
	@Autowired
	private ModuloService servicio;
	
	@DeleteMapping(path = "/modulos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> eliminarModulo(@PathVariable Integer id){
		Modulo modulo = servicio.getModuloById(id);
		if(modulo == null) return ResponseEntity.notFound().build();
		servicio.eliminarModulo(modulo);
		return ResponseEntity.ok(modulo);
	}
}
