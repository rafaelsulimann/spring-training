package br.com.sulimann.microservice_a.configs;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {

  @Value("${sulimann.resilience.timeout}")
  private int timeout;

  @Bean
  RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder
    .connectTimeout(Duration.ofSeconds(timeout))
    .readTimeout(Duration.ofSeconds(timeout))
    .build();
  }



}
