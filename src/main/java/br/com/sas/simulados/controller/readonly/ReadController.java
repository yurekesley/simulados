/**
 * 
 */
package br.com.sas.simulados.controller.readonly;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.sas.simulados.json.Json;
import br.com.sas.simulados.json.JsonResult;
import br.com.sas.simulados.model.IBaseModel;
import br.com.sas.simulados.service.readonly.IReadService;
import lombok.Getter;

/**
 * @author yure.placido
 * @Data 17 de fev de 2020
 */
public abstract class ReadController<T extends IBaseModel, ID extends Serializable> {

	@Getter
	@Autowired
	private IReadService<T, ID> service;

	@GetMapping(value = "/{id}")
	public JsonResult findById(@PathVariable(value = "id") ID id) {

		T entity = this.getService().findById(id);

		return Json.success() //
				.withData(entity) //
				.build();
	}

	@GetMapping
	public JsonResult findAll() {

		List<T> all = this.getService().findAll();

		return Json.success() //
				.withData(all) //
				.build();
	}
}
