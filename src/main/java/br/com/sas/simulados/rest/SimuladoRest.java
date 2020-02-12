/**
 * 
 */
package br.com.sas.simulados.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sas.simulados.exception.GenericException;
import br.com.sas.simulados.json.Json;
import br.com.sas.simulados.json.JsonResult;
import br.com.sas.simulados.model.Simulado;
import br.com.sas.simulados.util.RestUtil;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */
@RestController
@RequestMapping(value = "/simulados", produces = RestUtil.JSON_PRODUCE)
public class SimuladoRest {

	@GetMapping(produces = RestUtil.JSON_PRODUCE)
	public JsonResult getSimulados() {
		List<Simulado> simulados = new ArrayList<Simulado>();
		simulados.add(new Simulado());
		
		throw new GenericException("app.testes");
		
		/////////return Json.success().withData(simulados).build();
	}
}
