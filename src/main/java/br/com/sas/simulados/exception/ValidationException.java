/**
 * 
 */
package br.com.sas.simulados.exception;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */
public class ValidationException extends GenericException {

	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
		super(TypeError.DANGER, message);
	}

	public ValidationException(String message, Object... params) {
		super(TypeError.DANGER, message, params);
	}
}
