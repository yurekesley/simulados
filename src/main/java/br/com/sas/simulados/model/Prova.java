package br.com.sas.simulados.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Data;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */
@Entity
@Table(name = "SGS_PROVAS")
public @Data class Prova implements IBaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVAS_ID_SEQ")
	@SequenceGenerator(name = "SGS_PROVAS_ID_SEQ", sequenceName = "SGS_PROVAS_ID_SEQ")
	@Column(name = "PROVA_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "MATERIA_ID", referencedColumnName = "MATERIA_ID")
	private Materia materia;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@Column(name = "DATA_PROVA", columnDefinition = "DATE")
	private LocalDate data;

	@ManyToMany
	@JoinTable(name = "SGS_QUES_PROVA", joinColumns = { @JoinColumn(name = "PROVA_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "QUESTAO_ID") })
	private Set<Questao> questoes = new HashSet<Questao>();

}