package com.crud.gateway.provider;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.crud.gateway.dto.StudentDto;

import reactor.core.publisher.Mono;

@Service
public class LastNameProvider {

    private final WebClient webClient;

    public LastNameProvider() {
        this.webClient = WebClient.builder()
            .baseUrl("http://localhost:8081/api/v1")
            .build();
    }

    public Mono<StudentDto> get(UUID id) {
        return webClient.get()
            .uri("/students/{id}", id)
            .retrieve()
            .bodyToMono(StudentDto.class);
    }
}