package br.com.sas.simulados;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.support.ResourceBundleMessageSource;

import br.com.sas.simulados.util.ResourceBundleUtil;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SimuladosApplication implements CommandLineRunner {

	@Autowired
	private ResourceBundleMessageSource resourceBundle;

	public static void main(String[] args) {
		SpringApplication.run(SimuladosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(new Locale("pt", "BR"));
		ResourceBundleUtil.setResourceBundleMessageSource(resourceBundle);
	}

}
