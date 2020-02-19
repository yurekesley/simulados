package br.com.sas.simulados.service;

import org.springframework.stereotype.Service;

import br.com.sas.simulados.model.Gabarito;
import br.com.sas.simulados.service.readonly.ReadService;

@Service
public class GabaritoService extends ReadService<Gabarito, Long> {

}
