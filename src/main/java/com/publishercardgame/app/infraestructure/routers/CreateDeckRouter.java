package com.publishercardgame.app.infraestructure.routers;


import com.publishercardgame.app.application.usecases.CreateDecksUseCase;
import com.publishercardgame.app.application.usecases.ExtractorDecksUseCase;
import com.publishercardgame.app.domain.models.Decks;
import com.publishercardgame.app.infraestructure.handlers.CreateDecksHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class CreateDeckRouter {

    //@Autowired
    //private CreateDecksUseCase createDecksUseCase;

    @Bean
    public RouterFunction<ServerResponse> routes(CreateDecksHandler handler) {

       /* Function<Decks, Mono<ServerResponse>> executor = decks -> createDecksUseCase.get().flatMap(
                decks1 -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(decks1)
        );
        request -> request.bodyToMono(Decks.class).flatMap(executor)
        */
        return route(GET("/get"), handler::createDeck);
    }
}