package org.zabalburu.alumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zabalburu.alumnos.modelo.Alumno;

public interface AlumnosRepository extends JpaRepository<Alumno, Integer> {

}
