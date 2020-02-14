package br.com.sas.simulados;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.sas.simulados.dbunit.DbUnitConfig;
import br.com.triadworks.dbunit.DbUnitManager;
import br.com.triadworks.dbunit.dataset.ClassPathDataSetSource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SimuladosApplication.class, DbUnitConfig.class })
public abstract class SimuladosApplicationTestCase {

	@Autowired
	protected DbUnitManager dbunitManager;

	protected DataSource dataSource;

	public static final String DATASET_ALL_TABLES = "datasets/all-tables.xml";

	@Before
	public void setUp() {
		this.deleteAll(DATASET_ALL_TABLES);
	}

	protected void deleteAll(String dataset) {
		this.dbunitManager.deleteAll(new ClassPathDataSetSource(dataset));
	}

	protected void cleanAndInsert(String dataset) {
		this.dbunitManager.cleanAndInsert(new ClassPathDataSetSource(dataset));
	}

	protected String dataSet(String xml) {
		return "datasets/" + xml;
	}
}
