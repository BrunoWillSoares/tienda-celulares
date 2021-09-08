package com.tienda.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//@EnableWebSecurity
public class WebSecurityConfig  {

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.cors().configurationSource(request -> new
	 * CorsConfiguration().applyPermitDefaultValues()); }
	 * 
	 * @Bean CorsConfigurationSource corsConfigurationSource() {
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource();
	 * source.registerCorsConfiguration("/celulares", new
	 * CorsConfiguration().applyPermitDefaultValues());
	 * 
	 * //http.cors().configurationSource(request -> new
	 * CorsConfiguration().applyPermitDefaultValues()); return source; }
	 */
}