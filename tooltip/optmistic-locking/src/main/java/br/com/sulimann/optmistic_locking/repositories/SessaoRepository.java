package br.com.sulimann.optmistic_locking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sulimann.optmistic_locking.entities.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

}
