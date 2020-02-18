package br.com.sas.simulados.service;

import org.springframework.stereotype.Service;

import br.com.sas.simulados.model.Prova;
import br.com.sas.simulados.service.readonly.ReadService;

@Service
public class ProvaService extends ReadService<Prova, Long> {

}
