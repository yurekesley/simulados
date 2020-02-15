package br.com.sas.simulados.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SGS_RESPOSTAS")
public class Resposta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESPOSTAS_ID_SEQ")
	@SequenceGenerator(name = "SGS_RESPOSTAS_ID_SEQ", sequenceName = "SGS_RESPOSTAS_ID_SEQ")
	@Column(name = "RESPOSTA_ID")
	private Long id;
	
	@Column(name = "ENUNCIADO", columnDefinition = "TEXT")
	private String enunciado;
	

}
