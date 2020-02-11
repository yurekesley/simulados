package br.com.sas.simulados;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.sas.simulados.dbunit.DbUnitConfig;
import br.com.triadworks.dbunit.DbUnitManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SimuladosApplication.class, DbUnitConfig.class })
public abstract class SimuladosApplicationTestCase {

	@Autowired
	protected DbUnitManager dbunitManager;
}
