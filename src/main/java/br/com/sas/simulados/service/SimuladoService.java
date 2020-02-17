/**
 * 
 */
package br.com.sas.simulados.service;

import org.springframework.stereotype.Service;

import br.com.sas.simulados.model.Simulado;
import br.com.sas.simulados.service.readonly.ReadService;

/**
 * @author yure.placido
 * @Data 17 de fev de 2020
 */
@Service
public class SimuladoService extends ReadService<Simulado, Long> {

}
