package br.com.sas.simulados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sas.simulados.model.Gabarito;
import br.com.sas.simulados.model.Prova;
import br.com.sas.simulados.service.readonly.ReadService;
import lombok.Setter;

@Service
public class ProvaService extends ReadService<Prova, Long> {

	@Setter
	@Autowired
	private GabaritoService gabaritoService;

	@Setter
	@Autowired
	private ProvaService provaService;

	public Gabarito findGabaritoByProva(Long id) {
		Prova prova = provaService.findById(id);
		return gabaritoService.findByProva(prova);
	}

}
