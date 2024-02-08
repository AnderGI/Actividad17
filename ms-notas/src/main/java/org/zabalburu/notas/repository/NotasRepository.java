package org.zabalburu.notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zabalburu.notas.modelo.Nota;

public interface NotasRepository extends JpaRepository<Nota, Integer> {

}
