/**
 * 
 */
package br.com.sas.simulados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@Table(name = "SGS_NIVEL")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "descricao")
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public @Data class Nivel implements IBaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NIVEL_ID_SEQ")
	@SequenceGenerator(name = "NIVEL_ID_SEQ", sequenceName = "SGS_NIVEL_ID_SEQ", allocationSize = 1)
	@Column(name = "NIVEL_ID")
	private Long id;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "PONTOS")
	private Integer pontos;

}
