/**
 * 
 */
package br.com.sas.simulados.exception;

import br.com.sas.simulados.util.ResourceBundleUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */
@Slf4j
public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private TypeError typeError = TypeError.GENERIC;

	@Getter
	private Object[] params;

	public GenericException() {
		super();
	}

	public GenericException(TypeError typeError, String message) {
		super(message);
		this.typeError = typeError;
		log.info(message, this);
	}
	
	
	public GenericException(String message, Object... params) {
		super(message);
		this.typeError = TypeError.DANGER;
		this.params = params;
		log.info(message, this, params);
	}

	public GenericException(TypeError typeError, String message, Object... params) {
		this(typeError, message);
		this.params = params;
		log.info(message, this, params);
	}

	public int getCodigo() {
		return typeError.getCode();
	}

	@Override
	public String getLocalizedMessage() {
		return this.getMensagem();
	}

	public String getMensagem() {
		try {
			return ResourceBundleUtil.montarMensagem(this.getMessage(), this.getParams());
		} catch (Throwable ex) {
			return this.getMessage();
		}
	}

}
