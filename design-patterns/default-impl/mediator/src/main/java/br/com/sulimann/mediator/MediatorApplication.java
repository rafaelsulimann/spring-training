package br.com.sulimann.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MediatorApplication {

	@Autowired
	private ChatMediator mediator;

	public static void main(String[] args) {
		SpringApplication.run(MediatorApplication.class, args);
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			User alice = new ChatUser(mediator, "Alice");
			User bob = new ChatUser(mediator, "Bob");
			User carol = new ChatUser(mediator, "Carol");

			// Simula trocas de mensagens
			alice.send("Olá, time!");
			bob.send("Oi Alice, tudo bem?");
		};
	}

}
