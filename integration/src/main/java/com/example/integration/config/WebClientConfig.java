package com.example.integration.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@AllArgsConstructor
public class WebClientConfig {

    @Value("${apiKey}")
    private String apiKey;

    @Value("${apiKeyRespond}")
    private String apiKeyRespond;

    @Value("${apiHost}")
    private String apiHost;

    @Value("${apiHostRespond}")
    private String apiHostRespond;

    @Bean
    public WebClient webClientWalmart() {
        return WebClient.builder()
                .baseUrl("https://walmart.p.rapidapi.com")
                .defaultHeader(apiHost,apiHostRespond)
                .defaultHeader(apiKey,apiKeyRespond)
                .build();
    }
}
