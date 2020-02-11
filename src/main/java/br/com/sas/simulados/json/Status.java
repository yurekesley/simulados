/**
 * 
 */
package br.com.sas.simulados.json;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */
public enum Status {

	SUCCESS(200),

	FAIL(400),

	ERROR(500);

	private int defaultHttpCode;

	private Status(int defaultHttpCode) {
		this.defaultHttpCode = defaultHttpCode;
	}

	public int getHttpStatusCode() {
		return defaultHttpCode;
	}
}
