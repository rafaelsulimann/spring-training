package br.com.sulimann.decorator;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DecoratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecoratorApplication.class, args);
	}

	@Bean
	CommandLineRunner run(){
		return args -> {
			var baseProcessor = new BaseRequestProcessor();
			var loggingProcessor = new LoggingDecorator(baseProcessor);
			var validationProcessor = new ValidationDecorator(loggingProcessor);

			var pipelineProcessor = validationProcessor;

			pipelineProcessor.process(new Request("127.0.0.1", Map.of("Content-Type", "application/json")));
		};
	}

}
