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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */
@Entity
@Table(name = "SGS_SIMULADOS")
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public @Data class Simulado implements IBaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SIMULADOS_ID_SEQ")
	@SequenceGenerator(name = "SIMULADOS_ID_SEQ", sequenceName = "SGS_SIMULADOS_ID_SEQ", allocationSize = 1)
	@Column(name = "SIMULADO_ID")
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@Column(name = "DATA_SIMULADO", columnDefinition = "DATE")
	private LocalDate data;

	@ManyToMany
	@JoinTable(name = "SGS_SIMU_PROVA", joinColumns = { @JoinColumn(name = "SIMULADO_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PROVA_ID") })
	private Set<Prova> provas = new HashSet<Prova>();

}
