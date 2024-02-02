package com.example.modulos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modulos.modelo.Modulo;
import com.example.modulos.repository.ModulosRepository;


@Service
public class ModuloService {
	@Autowired
	private ModulosRepository repo;
	
	public List<Modulo> getModulos(){
		return repo.findAll();
	}
	
	public Modulo getModuloById(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public void eliminarModulo(Modulo modulo) {
		repo.delete(modulo);
		//return modulo;
	}
	public Modulo nuevoModulo(Modulo modulo) {
		return repo.save(modulo);
	}
	public Modulo modificarModulo(Modulo modulo) {
		if(modulo.getId() == null) {
			return null;
		}
		repo.save(modulo);
		return modulo;
	}
}
