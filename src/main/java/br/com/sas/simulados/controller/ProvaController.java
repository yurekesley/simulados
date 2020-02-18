package br.com.sas.simulados.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sas.simulados.controller.readonly.ReadController;
import br.com.sas.simulados.model.Prova;
import br.com.sas.simulados.util.RestUtil;

@RestController
@RequestMapping(value = "/provas", produces = RestUtil.JSON_PRODUCE)
public class ProvaController extends ReadController<Prova, Long> {

}
