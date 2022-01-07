package com.publishercardgame.app.application.usecases;


import com.publishercardgame.app.domain.models.Decks;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

@Service
public class ExtractorDecksUseCase implements Supplier<Mono<Decks>> {

    @Override
    public Mono<Decks> get() {
        return WebClient.create().get().uri("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Decks.class);
    }
}
