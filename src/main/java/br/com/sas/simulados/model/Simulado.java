/**
 * 
 */
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */
@Entity
@Table(name = "SGS_SIMULADOS")
public @Data class Simulado implements IBaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SIMULADOS_ID_SEQ")
	@SequenceGenerator(name = "SIMULADOS_ID_SEQ", sequenceName = "SGS_SIMULADOS_ID_SEQ", allocationSize = 1)
	@Column(name = "SIMULADO_ID")
	private Long id;

	@Column(name = "DATA_SIMULADO", columnDefinition = "DATE")
	private LocalDate data;

	@ManyToMany
	@JoinTable(name = "SGS_SIMU_PROVA", joinColumns = { @JoinColumn(name = "SIMULADO_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PROVA_ID") })
	private Set<Prova> provas = new HashSet<Prova>();

}
