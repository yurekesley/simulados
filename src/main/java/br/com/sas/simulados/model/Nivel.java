/**
 * 
 */
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

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */
@Entity
@Table(name = "SGS_NIVEL")
public @Data class Nivel implements Serializable {

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
