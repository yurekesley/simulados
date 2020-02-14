/**
 * 
 */
package br.com.sas.simulados.dbunit;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import br.com.triadworks.dbunit.DbUnitManager;
import br.com.triadworks.dbunit.DefaultDbUnitManagerImpl;
import br.com.triadworks.dbunit.connection.CachedDbUnitConnectionCreator;
import br.com.triadworks.dbunit.connection.DefaultDbUnitConnectionCreator;

/**
 * @author yure.placido
 * @Data 11 de fev de 2020
 */
@Configuration
@PropertySource("classpath:jdbc-local.properties")
public class DbUnitConfig {

	@Autowired
	private Environment env;

	@Bean
	public DbUnitManager dbunitManager(DataSource dataSource, CustomDbUnitDataSetResolver dataSetResolver) {
		CachedDbUnitConnectionCreator connectionCreator = new CachedDbUnitConnectionCreator(
				new DefaultDbUnitConnectionCreator(dataSource));
		DbUnitManager dbunitManager = new DefaultDbUnitManagerImpl(connectionCreator, dataSetResolver);
		return dbunitManager;
	}
	
	@Bean
	public DataSource dataSource() {
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		dataSource.setSuppressClose(true);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "br.com.sas.simulados" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		Map<String, Object> jpaProperties = new HashMap<String, Object>();
		jpaProperties.put("hibernate.show_sql", true);
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		jpaProperties.put("hibernate.format_sql", true);
		jpaProperties.put("spring.jpa.show-sql", true);
		jpaProperties.put("spring.jpa.format_sql", true);

		em.setJpaPropertyMap(jpaProperties);

		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
