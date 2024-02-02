package com.example.notas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.example.notas.modelo.Notas;
import com.example.notas.service.NotasServicio;

@RestController
public class NotasDeleteController {

	@Autowired
	public NotasServicio servicio;
	
	@DeleteMapping("/notas/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Notas nota = servicio.getNotaPorId(id);
		if(nota == null) return ResponseEntity.notFound().build();
		servicio.eliminarNota(nota);
		return ResponseEntity.ok(nota);
	}
}
