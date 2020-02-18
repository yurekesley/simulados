package br.com.sas.simulados.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "SGS_QUESTOES")
@EqualsAndHashCode
@ToString
public @Data class Questao implements IBaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTOES_ID_SEQ")
	@SequenceGenerator(name = "SGS_QUESTAO_ID_SEQ", sequenceName = "SGS_QUESTAO_ID_SEQ", allocationSize = 50)
	@Column(name = "QUESTAO_ID")
	private Long id;

	@Column(name = "ENUNCIADO", columnDefinition = "TEXT")
	private String enunciado;

	@ManyToOne
	@JoinColumn(name = "MATERIA_ID", referencedColumnName = "MATERIA_ID")
	private Materia materia;

	@ManyToOne
	@JoinColumn(name = "NIVEL_ID", referencedColumnName = "NIVEL_ID")
	private Nivel nivel;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "QUESTAO_ID")
	private Set<Resposta> respostas = new HashSet<Resposta>();

}