package org.zabalburu.modulos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zabalburu.modulos.modelo.Modulo;
import org.zabalburu.modulos.repository.ModulosRepository;

@Service
public class ModulosService {
	@Autowired
	private ModulosRepository dao;

	public List<Modulo> getModulos() {
		return dao.findAll();
	}

	public Modulo getModulo(Integer id) {
		return dao.findById(id).orElse(null);
	}

	public Modulo nuevoModulo(Modulo nuevo) {
		if (nuevo.getNombre() == null || nuevo.getProfesor() == null) {
			return null;
		}
		dao.save(nuevo);
		return nuevo;
	}

	public Modulo modificarModulo(Modulo modificar) {
		/*
		 * dao.save(modificar); return modificar;
		 */
		Modulo m = getModulo(modificar.getId());
		if (m != null) {
			if (modificar.getNombre() != null) {
				m.setNombre(modificar.getNombre());
			}
			if (modificar.getProfesor() != null) {
				m.setProfesor(modificar.getProfesor());
			}
			dao.save(m);
			return m;
		}
		return null;
	}

	public boolean eliminarModulo(Integer id) {
		if (getModulo(id) != null) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}
}
