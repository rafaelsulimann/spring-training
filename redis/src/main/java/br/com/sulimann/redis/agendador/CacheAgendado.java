package br.com.sulimann.redis.agendador;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CacheAgendado {

  @Scheduled(fixedDelay = 30, timeUnit = TimeUnit.MINUTES)
  @CacheEvict(value = "usuarios")
  public void clearCache() {
    log.info("Limpando cache de usuários");
  }
}
