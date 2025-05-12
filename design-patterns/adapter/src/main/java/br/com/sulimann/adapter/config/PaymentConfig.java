package br.com.sulimann.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.sulimann.adapter.external.ThirdPartyPaymentService;

@Configuration
public class PaymentConfig {

    @Bean
    public ThirdPartyPaymentService thirdPartyPaymentService() {
        return new ThirdPartyPaymentService();
    }
}
