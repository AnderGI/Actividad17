package com.example.notas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notas.modelo.Notas;
import com.example.notas.repository.NotasRepository;



@Service
public class NotasServicio {
	@Autowired
	private NotasRepository notas;
	
	public List<Notas> getNotas(){
		return notas.findAll();
	}
	
	public Notas getNotaPorId(Integer id) {
		return notas.findById(id).orElse(null);
	}
	
	public List<Notas> getNotasPorModulo(Integer idModulo){
		return notas.findByIdModulo(idModulo);
	}
	
	public List<Notas> getNotasPorAlumno(Integer idAlumno){
		return notas.findByIdAlumno(idAlumno);
	}
	
	public Notas nuevaNota(Notas nota) {
		return notas.save(nota);
	}
	
	public void eliminarNota(Notas nota) {
		notas.delete(nota);
	}
	
	public Notas modificar(Notas nota) {
		if(nota.getId() == null) return null;
		notas.save(nota);
		return nota;
	}
}
