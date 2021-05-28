package br.com.gustavoakira.bootcamp;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${application.description}") String title){
		return new OpenAPI().info(
				new Info()
				.title(title)
				.version("1.0")
				.termsOfService("")
				.license(new License().name("Apache 2.0")
		));
	}
}