package com.example.springboot;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			Iterable<User> iter = repository.findAll();

			if (!iter.iterator().hasNext()) {
				User user = new User();
				user.setName("Jaron");
				repository.save(user);
			}
		};
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		corsConfiguration.setAllowedHeaders(Arrays.asList(
				"Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept",
				"X-Requested-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"
		));
		corsConfiguration.setExposedHeaders(Arrays.asList(
				"Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept",
				"X-Requested-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"
		));
		corsConfiguration.setAllowedMethods(Arrays.asList(
				"GET","POST","PUT","DELETE","OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource =
				new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
