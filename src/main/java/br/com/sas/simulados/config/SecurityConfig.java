/**
 * 
 */
package br.com.sas.simulados.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yure.placido
 * @Data 18 de fev de 2020
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth //
				.inMemoryAuthentication()//
				.withUser("sas") //
				.password(encoder.encode("sas@123")) //
				.roles("USER") //
				.and() //
				.withUser("admin") //
				.password(encoder.encode("admin")) //
				.roles("USER", "ADMIN");
	}
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	          .authorizeRequests()
	          .anyRequest()
	          .authenticated()
	          .and()
	          .httpBasic();
	    }

}
