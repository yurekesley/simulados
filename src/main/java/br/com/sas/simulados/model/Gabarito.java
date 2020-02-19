package br.com.sas.simulados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "SGS_GABARITO")
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public @Data class Gabarito implements IBaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GABARITO_ID_SEQ")
	@SequenceGenerator(name = "SGS_GABARITO_ID_SEQ", sequenceName = "SGS_GABARITO_ID_SEQ", allocationSize = 50)
	@Column(name = "GABARITO_ID")
	private Long id;

	@OneToOne
	@JoinColumn(name = "PROVA_ID", referencedColumnName = "PROVA_ID")
	private Prova prova;

}
