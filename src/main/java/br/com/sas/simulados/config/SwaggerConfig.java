package br.com.sas.simulados.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket greetingApi() {
		return new Docket(DocumentationType.SWAGGER_2) //
				.select() //
				.apis(RequestHandlerSelectors.basePackage("br.com.sas.simulados")) //
				.build() //
				.apiInfo(metaData());
	}
		
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Números por extenso") //
				.description("\"Spring Boot REST API") //
				.version("0.0.1-SNAPSHOT") //
				.license("GitHub") //
				.licenseUrl("https://github.com/yurekesley/simulados") //
				.build();
	}
}
