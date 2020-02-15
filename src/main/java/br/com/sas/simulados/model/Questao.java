package br.com.sas.simulados.model;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SGS_QUESTOES")
public @Data class Questao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTOES_ID_SEQ")
	@SequenceGenerator(name = "SGS_QUESTAO_ID_SEQ", sequenceName = "SGS_QUESTAO_ID_SEQ", allocationSize = 50)
	@Column(name = "QUESTAO_ID")
	private Long id;

	@Column(name = "ENUNCIADO", columnDefinition = "TEXT")
	private String enunciado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATERIA_ID", referencedColumnName = "MATERIA_ID")
	private Materia materia;

}