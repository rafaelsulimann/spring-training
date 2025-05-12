package br.com.sulimann.factory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FactoryApplication {

	private final NotificacaoFactory emailNotificacaoFactory;
	private final NotificacaoFactory smsNotificacaoFactory;
	private final NotificacaoFactory pushNotificacaoFactory;
	private final NotificacaoFactory whatsappNotificacaoFactory;

	public FactoryApplication(@Qualifier("email") NotificacaoFactory emailNotificacaoFactory,
			@Qualifier("sms") NotificacaoFactory smsNotificacaoFactory,
			@Qualifier("push") NotificacaoFactory pushNotificacaoFactory,
			@Qualifier("whatsapp") NotificacaoFactory whatsappNotificacaoFactory) {
		this.emailNotificacaoFactory = emailNotificacaoFactory;
		this.smsNotificacaoFactory = smsNotificacaoFactory;
		this.pushNotificacaoFactory = pushNotificacaoFactory;
		this.whatsappNotificacaoFactory = whatsappNotificacaoFactory;
	}

	public static void main(String[] args) {
		SpringApplication.run(FactoryApplication.class, args);
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			this.emailNotificacaoFactory.enviarNotificacao("Teste de notificação");
			this.smsNotificacaoFactory.enviarNotificacao("Teste de notificação");
			this.pushNotificacaoFactory.enviarNotificacao("Teste de notificação");
			this.whatsappNotificacaoFactory.enviarNotificacao("Teste de notificação");
		};
	}

}
