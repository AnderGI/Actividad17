package com.example.modulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.modulos.modelo.Modulo;

@Repository
public interface ModulosRepository extends JpaRepository<Modulo, Integer> {

}
