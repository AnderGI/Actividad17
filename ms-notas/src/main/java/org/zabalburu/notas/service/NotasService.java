package org.zabalburu.notas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.zabalburu.notas.exceptions.IdsErroneosException;
import org.zabalburu.notas.exceptions.NotFoundException;
import org.zabalburu.notas.modelo.Nota;
import org.zabalburu.notas.repository.NotasRepository;

@Service
public class NotasService {
	@Autowired
	private NotasRepository dao;

	 @Autowired
	 private RestTemplate template;
	
	public List<Nota> getNotas() {
		return dao.findAll();
	}

	public Nota getNota(Integer id) {
		return dao.findById(id).orElse(null);
	}

	public Nota nuevoNota(Nota nuevo) throws Exception{
		try {
			template.getForObject("http://servicio-alumnos:8005/alumnos/{id}", 
				Object.class, nuevo.getIdAlumno());
		} catch (HttpClientErrorException.NotFound ex) {
			throw new IdsErroneosException("Alumno no encontrado");
		}
		try {
			template.getForObject("http://servicio-modulos:8010/modulos/{id}", 
				Object.class, nuevo.getIdModulo());
		} catch (HttpClientErrorException.NotFound ex) {
			throw new IdsErroneosException("Módulo no encontrado");
		}
		dao.save(nuevo);
		return nuevo;
	}

	public Nota modificarNota(Nota modificar) {
		if (getNota(modificar.getId()) == null) {
			return null;
		}
		try {
			template.getForObject("http://localhost:8005/alumnos/{id}", 
				Object.class, modificar.getIdAlumno());
			template.getForObject("http://localhost:8010/modulos/{id}", 
				Object.class, modificar.getIdModulo());
			dao.save(modificar);
			return modificar;
		} catch (HttpClientErrorException.NotFound ex) {
			return null;
		}
	}

	public boolean eliminarNota(Integer id) {
		if (getNota(id) != null) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}
}
