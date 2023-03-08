package com.crud.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Value("${services.names.base-url}")
    private String baseUrl;
    
    @Bean
    public WebClient namesWebClient()
    {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }
}
