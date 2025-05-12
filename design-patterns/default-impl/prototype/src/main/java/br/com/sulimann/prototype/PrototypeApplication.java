package br.com.sulimann.prototype;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrototypeApplication.class, args);
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			User user = new User("John Doe", "john.doe@example.com", "password");
			User userClone = user.clone();
			System.out.println(userClone);
			System.out.println(user);
		};
	}

}
