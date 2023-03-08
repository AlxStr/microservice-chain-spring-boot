package com.crud.middlename.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.crud.middlename.dto.InputDto;
import com.crud.middlename.dto.LastnameDto;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class LastnameService {

    @Autowired
    @Qualifier("lastnameWebClient")
    private final WebClient webClient;

    public LastnameDto getLastname(UUID ownerId) {
        return this.webClient.get()
            .uri("/{id}", ownerId)
            .retrieve()
            .bodyToMono(LastnameDto.class)
            .block();
    }

    public LastnameDto updateLastname(UUID ownerId, InputDto input) {
        return this.webClient.put()
            .uri("/{id}", ownerId)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(input), InputDto.class)
            .retrieve()
            .bodyToMono(LastnameDto.class)
            .block();
    }
}
