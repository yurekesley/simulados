package br.com.sas.simulados.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "SGS_QUESTOES")
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public @Data class Questao implements IBaseModel {

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NIVEL_ID", referencedColumnName = "NIVEL_ID")
	private Nivel nivel;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "QUESTAO_ID")
	private Set<Resposta> respostas = new HashSet<Resposta>();
	
	@JsonIgnore
	@OneToOne
	@JoinTable(name = "SGS_GABARITO_QUESTAO", joinColumns = { @JoinColumn(name = "QUESTAO_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "RESPOSTA_ID") })
	private Resposta resposta;

}