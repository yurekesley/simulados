package br.com.sas.simulados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sas.simulados.model.Gabarito;
import br.com.sas.simulados.model.Prova;
import br.com.sas.simulados.service.readonly.ReadService;

@Service
public class ProvaService extends ReadService<Prova, Long> {
	
	@Autowired
	private GabaritoService gabaritoService;
	
	public Gabarito findGabaritoByProvaId(Long provaId) {
		Prova prova = this.findById(provaId);
		return gabaritoService.findByProva(prova);
	}

}
