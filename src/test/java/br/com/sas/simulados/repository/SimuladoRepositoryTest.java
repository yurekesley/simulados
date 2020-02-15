/**
 * 
 */
package br.com.sas.simulados.repository;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.sas.simulados.SimuladosApplicationTestCase;
import br.com.sas.simulados.model.Prova;
import br.com.sas.simulados.model.Simulado;

/**
 * @author yure.placido
 * @Data 14 de fev de 2020
 */
public class SimuladoRepositoryTest extends SimuladosApplicationTestCase {

	private static final String PATH_DATASET_SIMULADOS = "simulados/";

	@Autowired
	SimuladoRepository repo;

	@Test
	public void deveInserirSimulados() {
		this.cleanAndInsert(dataSet(PATH_DATASET_SIMULADOS + "dataset-deveInserirSimulados.xml"));
		List<Simulado> findAll = repo.findAll();
		for (Simulado simulado : findAll) {
			Set<Prova> provas = simulado.getProvas();
			System.out.println(provas);
		}
	}
}
