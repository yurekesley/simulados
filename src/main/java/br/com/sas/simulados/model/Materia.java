package br.com.sas.simulados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "SGS_MATERIAS")
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public @Data class Materia implements IBaseModel {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MATERIAS_ID_SEQ")
	@SequenceGenerator(name = "SGS_MATERIAS_ID_SEQ", sequenceName = "SGS_MATERIAS_ID_SEQ", allocationSize = 50)
	@Column(name = "MATERIA_ID")
	private Long id;

	@Column(name = "DESCRICAO")
	private String descricao;

}