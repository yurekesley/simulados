/**
 * 
 */
package br.com.sas.simulados.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

import br.com.sas.simulados.SimuladosApplicationTestCase;

/**
 * @author yure.placido
 * @Data 19 de fev de 2020
 */
public class ProvaControllerTest extends SimuladosApplicationTestCase {

	private static final String PATH_DATASET_PROVA = "provas/";

	@Test
	public void deveConsultarProvasPorId() throws Exception {
		this.cleanAndInsert(dataSet(PATH_DATASET_PROVA + "dataset-deveConsultarProvasPorId.xml"));

		mvc.perform(get("/provas/{id}", 1)//
				.contentType(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("data.id").value(1));
	}

	@Test
	public void deveConsultarTodasAsProvas() throws Exception {
		this.cleanAndInsert(dataSet(PATH_DATASET_PROVA + "dataset-deveConsultarProvasPorId.xml"));

		mvc.perform(get("/provas")//
				.contentType(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("data", hasSize(2)));
	}

	@Test
	public void deveConsultarGabaritoDaProva() throws Exception {
		this.cleanAndInsert(dataSet(PATH_DATASET_PROVA + "dataset-deveConsultarGabaritoDaProva.xml"));

		mvc.perform(get("/provas/{id}/gabarito", 1)//
				.contentType(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("data.id").value(1));
	}

}
