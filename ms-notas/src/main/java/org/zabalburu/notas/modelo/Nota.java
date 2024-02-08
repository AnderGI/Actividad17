package org.zabalburu.notas.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "notas")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	private Integer idAlumno;
	private Integer idModulo;
	private Integer evaluacion;
	private Double nota;

}
