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
 * @Data 14 de fev de 2020
 */
public class SimuladoControllerTest extends SimuladosApplicationTestCase {

	private static final String PATH_DATASET_SIMULADOS = "simulados/";

	@Test
	public void deveConsultarSimuladosPorId() throws Exception {
		this.cleanAndInsert(dataSet(PATH_DATASET_SIMULADOS + "dataset-deveConsultarSimuladosPorId.xml"));

		mvc.perform(get("/simulados/1")//
				.contentType(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("data.id").value(1));
	}

	@Test
	public void deveConsultarTodosSimulados() throws Exception {
		this.cleanAndInsert(dataSet(PATH_DATASET_SIMULADOS + "dataset-deveConsultarTodosSimulados.xml"));

		mvc.perform(get("/simulados")//
				.contentType(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("data", hasSize(2)));
	}

}
