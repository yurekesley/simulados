package br.com.sas.simulados.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SGS_GABARITO_QUESTAO")
@AllArgsConstructor
@NoArgsConstructor
public @Data class GabaritoQuestao implements IBaseModel {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GabaritoQuestaoId id;
}
