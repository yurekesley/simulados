package br.com.sas.simulados.config;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.sas.simulados.util.ResourceBundleUtil;

@AutoConfigureMockMvc
public class TestWebAppConfig implements WebMvcConfigurer {

	@Bean
	public ResourceBundleMessageSource resourceBundle() {
		ResourceBundleMessageSource resourceBundle = new ResourceBundleMessageSource();
		ResourceBundleUtil.setResourceBundleMessageSource(resourceBundle);
		return resourceBundle;
	}

}
