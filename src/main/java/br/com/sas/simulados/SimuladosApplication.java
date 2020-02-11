package br.com.sas.simulados;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ResourceBundleMessageSource;

import br.com.sas.simulados.util.ResourceBundleUtil;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
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

		try {

		} catch (Throwable ex) {
			log.error("Falha no processamento de gerar solicitações", ex);
		}
	}

}
