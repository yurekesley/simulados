/**
 * 
 */
package br.com.sas.simulados.repository;

import org.junit.Test;

import br.com.sas.simulados.SimuladosApplicationTestCase;

/**
 * @author yure.placido
 * @Data 14 de fev de 2020
 * */
public class SimuladoRepositoryTest extends SimuladosApplicationTestCase {
	
	private static final String PATH_DATASET_SIMULADOS = "simulados/";
	
	@Test
	public void deveInserirSimulados() {
		this.cleanAndInsert(dataSet(PATH_DATASET_SIMULADOS + "dataset-deveInserirSimulados.xml"));
	
	}
}
