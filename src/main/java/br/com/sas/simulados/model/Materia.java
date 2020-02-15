package br.com.sas.simulados.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SGS_MATERIAS")
public @Data class Materia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MATERIAS_ID_SEQ")
	@SequenceGenerator(name = "SGS_MATERIAS_ID_SEQ", sequenceName = "SGS_MATERIAS_ID_SEQ", allocationSize = 50)
	@Column(name = "MATERIA_ID")
	private Long id;

	@Column(name = "DESCRICAO")
	private String descricao;

}