package br.com.sulimann.optmistic_locking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.OptimisticLockingFailureException;

import br.com.sulimann.optmistic_locking.entities.Sessao;
import br.com.sulimann.optmistic_locking.repositories.SessaoRepository;

@SpringBootApplication
public class OptmisticLockingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptmisticLockingApplication.class, args);
	}

	@Bean
	CommandLineRunner run (SessaoRepository sessaoRepository) {
		return args -> {
			var sessao = new Sessao("Filme 1", 2020, 100);
			sessaoRepository.save(sessao);

			var todasSessoes = sessaoRepository.findAll();

			if(!todasSessoes.isEmpty()) {
				try {
					todasSessoes.forEach(s -> {
						s.atualizarQuantidade(s.getQuantidade() - 1);
						sessaoRepository.save(s);
					});
				} catch (OptimisticLockingFailureException e) {
					e.printStackTrace();
				}
			}
		};
	}

}
