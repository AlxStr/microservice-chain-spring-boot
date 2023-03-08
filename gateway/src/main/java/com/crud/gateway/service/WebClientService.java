package com.crud.gateway.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.crud.gateway.dto.StudentDto;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientService {

    @Autowired
    @Qualifier("namesWebClient")
    private final WebClient webClient;

    public StudentDto getNames(UUID ownerId) {
        return webClient.get()
            .uri("/{id}", ownerId)
            .retrieve()
            .bodyToMono(StudentDto.class)
            .block();
    }

    public StudentDto updateNames(UUID ownerId, StudentDto input) {
        return this.webClient.put()
            .uri("/{id}", ownerId)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(input), StudentDto.class)
            .retrieve()
            .bodyToMono(StudentDto.class)
            .block();
    }
}
