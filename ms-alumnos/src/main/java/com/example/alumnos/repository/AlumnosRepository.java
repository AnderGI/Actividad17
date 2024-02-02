package com.example.alumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alumnos.model.Alumno;

@Repository
public interface AlumnosRepository extends JpaRepository<Alumno, Integer> {

}
