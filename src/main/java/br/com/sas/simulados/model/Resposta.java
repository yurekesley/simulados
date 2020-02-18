package br.com.sas.simulados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "SGS_RESPOSTAS")
@EqualsAndHashCode
@ToString
public @Data class Resposta implements IBaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESPOSTAS_ID_SEQ")
	@SequenceGenerator(name = "SGS_RESPOSTAS_ID_SEQ", sequenceName = "SGS_RESPOSTAS_ID_SEQ")
	@Column(name = "RESPOSTA_ID")
	private Long id;

	@Column(name = "ENUNCIADO", columnDefinition = "TEXT")
	private String enunciado;

}
