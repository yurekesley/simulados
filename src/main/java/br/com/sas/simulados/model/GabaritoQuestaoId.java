/**
 * 
 */
package br.com.sas.simulados.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author yure.placido
 * @Data 19 de fev de 2020
 */
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class GabaritoQuestaoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "QUESTAO_ID", referencedColumnName = "QUESTAO_ID")
	private Questao questao;

	@OneToOne
	@JoinColumn(name = "RESPOSTA_ID", referencedColumnName = "RESPOSTA_ID")
	private Resposta resposta;

}
