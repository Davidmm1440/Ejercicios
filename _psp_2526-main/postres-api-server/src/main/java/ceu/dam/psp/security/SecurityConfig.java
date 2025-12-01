package ceu.dam.psp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@SecurityScheme(name = "ApiKeyAutentication",
					type = SecuritySchemeType.APIKEY,
					in = SecuritySchemeIn.HEADER,
					paramName = "API-KEY")
public class SecurityConfig {

	@Autowired
	private ApiKeyFilter apiKeyFilter;

	@Bean
	SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {

		// Permitimos peticiones POST/PUT/DELETE
		http.csrf(c -> c.disable());
		// Desactivamos formulario de login añadido por la extension
		http.formLogin(f -> f.disable());
		// Añadimos nuestro filtro. Hay que hacerlo en algun lugar. Lo hacemos delante
		// de otro ya existente de SpringSecurity
		http.addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
