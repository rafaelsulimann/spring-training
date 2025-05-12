package br.com.sulimann.builder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.sulimann.builder.utils.SqlQueryBuilder;

@SpringBootApplication
public class BuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuilderApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		// Usando lambda
		return args -> {
			var query = SqlQueryBuilder.create()
					.select("id", "name")
					.from("users")
					.where("id = 1")
					.build();
			System.out.println("Query gerada: " + query);
		};
	}

	// Exemplo alternativo usando classe anônima
	@Bean
	public CommandLineRunner outroExemplo() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {

				var query = SqlQueryBuilder.create()
						.select("email", "password")
						.from("users")
						.where("active = true")
						.build();
				System.out.println("Outra query: " + query);
			}
		};
	}
}
