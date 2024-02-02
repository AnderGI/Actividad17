package com.example.notas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.notas.modelo.Notas;

@Repository
public interface NotasRepository extends JpaRepository<Notas, Integer> {
	List<Notas> findByIdModulo(Integer idModulo);
	List<Notas> findByIdAlumno(Integer idAlumno);
}
