package br.com.sas.simulados.controller.readonly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sas.simulados.json.Json;
import br.com.sas.simulados.json.JsonResult;
import br.com.sas.simulados.model.Gabarito;
import br.com.sas.simulados.model.Prova;
import br.com.sas.simulados.service.ProvaService;
import br.com.sas.simulados.util.RestUtil;

@RestController
@RequestMapping(value = "/provas", produces = RestUtil.JSON_PRODUCE)
public class ProvaController extends ReadController<Prova, Long> {

	@Autowired
	private ProvaService provaService;

	@GetMapping(value = "/{id}/gabarito")
	public JsonResult findGabaritoByProva(@PathVariable(value = "id") Long id) {

		Gabarito gabarito = provaService.findGabarito(id);

		return Json.success() //
				.withData(gabarito) //
				.build();
	}
}
