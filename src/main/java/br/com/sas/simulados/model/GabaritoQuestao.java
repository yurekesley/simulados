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
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SGS_GABARITO_QUESTAO")
@AllArgsConstructor
@NoArgsConstructor
public @Data class RespostaQuestao implements IBaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GABARITO_QUESTAO_ID_SEQ")
	@SequenceGenerator(name = "SGS_GABARITO_QUESTAO_ID_SEQ", sequenceName = "SGS_GABARITO_QUESTAO_ID_SEQ")
	@Column(name = "GABARITO_QUESTAO_ID")
	private Long id;

	@OneToOne
	@JoinColumn(name = "GABARITO_ID", referencedColumnName = "GABARITO_ID")
	private Gabarito gabarito;

	@OneToOne
	@JoinColumn(name = "QUESTAO_ID", referencedColumnName = "QUESTAO_ID")
	private Questao questao;

	@OneToOne
	@JoinColumn(name = "RESPOSTA_ID", referencedColumnName = "RESPOSTA_ID")
	private Resposta resposta;

}
