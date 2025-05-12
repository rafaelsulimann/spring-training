package br.com.sulimann.template;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}

	@Bean
	CommandLineRunner run(){
		return args -> {
			Bebida bebida = new Cafe();
			bebida.preparar();

			bebida = new Cerveja();
			bebida.preparar();
		};
	}

}
