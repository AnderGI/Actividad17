package com.example.notas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.notas.modelo.Notas;
import com.example.notas.service.NotasServicio;

@RestController
public class NotasGetController {
	@Autowired
	private NotasServicio servicio;
	@GetMapping("/notas")
	public ResponseEntity<List<Notas>> getNotas(){
		return ResponseEntity.ok(servicio.getNotas());
	}
	@GetMapping("/notas/{id}")
	public ResponseEntity<Notas> getNotaPorId(@PathVariable Integer id){
		Notas nota = servicio.getNotaPorId(id);
		if(nota == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(nota);
	}	
	@GetMapping("/notas/modulos/{id}")
	public ResponseEntity<List<Notas>> getNotasPorModuloId(@PathVariable Integer id){
		
		return ResponseEntity.ok(servicio.getNotasPorModulo(id));
	}
	@GetMapping("/notas/alumnos/{id}")
	public ResponseEntity<List<Notas>> getNotasPorAlumnoId(@PathVariable Integer id){
		
		return ResponseEntity.ok(servicio.getNotasPorAlumno(id));
	}
}
