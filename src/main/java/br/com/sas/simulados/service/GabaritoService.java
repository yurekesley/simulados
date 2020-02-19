package br.com.sas.simulados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sas.simulados.exception.GenericException;
import br.com.sas.simulados.model.Gabarito;
import br.com.sas.simulados.model.Prova;
import br.com.sas.simulados.repository.GabaritoRepository;
import br.com.sas.simulados.service.readonly.ReadService;

@Service
public class GabaritoService extends ReadService<Gabarito, Long> {

	@Autowired
	private GabaritoRepository gabaritoRepository;

	public Gabarito findByProva(Prova prova) {
		Gabarito gabarito = gabaritoRepository.findByProva(prova);
		
		if (gabarito == null ) {
			throw new GenericException("msg.crud.error.notfound");
		}
		
		return gabarito;
	}

}
