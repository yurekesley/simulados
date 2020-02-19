package br.com.sas.simulados.controller.readonly;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sas.simulados.model.Gabarito;
import br.com.sas.simulados.util.RestUtil;

@RestController
@RequestMapping(value = "/gabaritos", produces = RestUtil.JSON_PRODUCE)
public class GabaritoController extends ReadController<Gabarito, Long> {

}
