package com.example.notas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.notas.modelo.Notas;
import com.example.notas.service.NotasServicio;

@RestController
public class NotasPutController {
	@Autowired
	private NotasServicio servicio;
	
	@PutMapping(path = "/notas/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Notas> nuevaNota(@PathVariable Integer id, @RequestBody Notas nota){
		nota.setId(id);
		Notas modificada = servicio.modificar(nota);
		if(nota == null) ResponseEntity.notFound().build();
		return ResponseEntity.ok(nota);
	}
}
