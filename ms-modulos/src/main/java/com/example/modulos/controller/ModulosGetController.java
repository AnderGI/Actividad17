package com.example.modulos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.modulos.modelo.Modulo;
import com.example.modulos.service.ModuloService;

@RestController
public class ModulosGetController {
	@Autowired
	private ModuloService servicio;
	@GetMapping("/modulos")
	public ResponseEntity<List<Modulo>> getModulos(){
		return ResponseEntity.ok(servicio.getModulos());
	}
	@GetMapping("/modulos/{id}")
	public ResponseEntity<Modulo> getModuloById(@PathVariable Integer id){
		return ResponseEntity.ok(servicio.getModuloById(id));
	}
}
