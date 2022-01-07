package com.publishercardgame.app.infraestructure.handlers;


import com.publishercardgame.app.application.usecases.CreateDecksUseCase;
import com.publishercardgame.app.domain.models.Decks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Service
public class CreateDecksHandler {

    @Autowired
    private CreateDecksUseCase createDecksUseCase;


    public Mono<ServerResponse> createDeck(ServerRequest serverRequest) {
        return createDecksUseCase.get().flatMap(decks -> ServerResponse.ok().
                contentType(MediaType.APPLICATION_JSON)
                .bodyValue(decks));

    }
}
