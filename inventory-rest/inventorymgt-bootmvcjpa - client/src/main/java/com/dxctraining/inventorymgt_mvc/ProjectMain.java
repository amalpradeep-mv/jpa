package com.dxctraining.inventorymgt_mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @SpringBootapplication equivalent to 3 things 1)@Configuration : so we don't
 *                        have to provide on our own 2)@ComponentScan: so we
 *                        don't have to provide on our own 3) @AutoConfiguration
 *                        so we don't have to provide on our own
 */
@SpringBootApplication
public class ProjectMain {

	public static void main(String[] args) {
		SpringApplication.run(ProjectMain.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedHeader("*");
		configuration.addAllowedOrigin("*");
		configuration.addAllowedMethod("*");
		src.registerCorsConfiguration("/**", configuration);
		return new CorsFilter(src);
	}
}