/**
 * 
 */
package br.com.sas.simulados.controller.readonly;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sas.simulados.model.Simulado;
import br.com.sas.simulados.util.RestUtil;

/**
 * @author yure.placido
 * @Data 17 de fev de 2020
 */
@RestController
@RequestMapping(value = "/simulados", produces = RestUtil.JSON_PRODUCE)
public class SimuladoController extends ReadController<Simulado, Long> {

}
