/**
 * 
 */
package br.com.sas.simulados.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public @Data class JsonResult {

	@NonNull
	private Status status;

	@NonNull
	private String mensagem;

	private Object data;

	private Integer code;

}
