package br.com.sas.simulados;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.sas.simulados.config.TestWebAppConfig;
import br.com.sas.simulados.dbunit.DbUnitConfig;
import br.com.triadworks.dbunit.DbUnitManager;
import br.com.triadworks.dbunit.dataset.ClassPathDataSetSource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SimuladosApplication.class, TestWebAppConfig.class, DbUnitConfig.class })
@WithMockUser(username = "sas", password = "123", roles = "ADMIN")
public abstract class SimuladosApplicationTestCase {

	public static final String codUsuarioPadrao = "sas";

	@Autowired
	protected DbUnitManager dbunitManager;

	protected DataSource dataSource;

	@Autowired
	protected MockMvc mvc;

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
