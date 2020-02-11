/**
 * 
 */
package br.com.sas.simulados.json;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */
public class JsonResultBuilder {

	private JsonResult jsonResult;

	public JsonResultBuilder success() {
		this.jsonResult = new JsonResult();
		this.jsonResult.setStatus(Status.SUCCESS);
		this.jsonResult.setCode(200);
		return this;
	}

	public JsonResultBuilder error() {
		this.jsonResult = new JsonResult();
		this.jsonResult.setStatus(Status.ERROR);
		this.jsonResult.setCode(500);
		return this;
	}

	public JsonResultBuilder fail() {
		this.jsonResult = new JsonResult();
		this.jsonResult.setStatus(Status.FAIL);
		this.jsonResult.setCode(400);
		return this;
	}

	public JsonResultBuilder withMensagem(String mensagem) {
		this.jsonResult.setMensagem(mensagem);
		return this;
	}

	public JsonResultBuilder withMensagem(String mensagem, int errorCode) {
		this.jsonResult.setMensagem(mensagem);
		this.withCode(errorCode);
		return this;
	}

	public JsonResultBuilder withData(Object data) {
		this.jsonResult.setData(data);
		return this;
	}

	public JsonResultBuilder withCode(int errorCode) {
		this.jsonResult.setCode(errorCode);
		return this;
	}

	public JsonResult build() {
		return jsonResult;
	}

}