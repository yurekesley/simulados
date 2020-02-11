/**
 * 
 */
package br.com.sas.simulados.json;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */

public class Json {

	public static JsonResultBuilder success() {
		return new JsonResultBuilder().success();
	}

	public static JsonResultBuilder error() {
		return new JsonResultBuilder().error();
	}

	public static JsonResultBuilder fail() {
		return new JsonResultBuilder().fail();
	}
}	
