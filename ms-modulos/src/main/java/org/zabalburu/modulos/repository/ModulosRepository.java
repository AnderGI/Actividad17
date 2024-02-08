package org.zabalburu.modulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zabalburu.modulos.modelo.Modulo;

public interface ModulosRepository
	extends JpaRepository<Modulo, Integer> {

}
