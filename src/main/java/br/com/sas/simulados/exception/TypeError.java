/**
 * 
 */
package br.com.sas.simulados.exception;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 * */
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TypeError {

	GENERIC(0), INFO(1), WARNING(2), DANGER(3);

	@Getter
	private final int code;

}
