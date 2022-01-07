package com.publishercardgame.app.application.usecases;


import com.google.gson.Gson;
import com.publishercardgame.app.application.config.RabbitMQConfig;
import com.publishercardgame.app.domain.models.Decks;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;


@Service
public class CreateDecksUseCase implements Supplier<Mono<Decks>> {
    @Autowired
    private final RabbitTemplate rabbitTemplate;
    @Autowired
    private Gson gson;

    @Autowired
    private ExtractorDecksUseCase extractorDecksUseCase;

    public CreateDecksUseCase(RabbitTemplate rabbitTemplate, ExtractorDecksUseCase extractorDecksUseCase) {
        this.rabbitTemplate = rabbitTemplate;
        this.extractorDecksUseCase = extractorDecksUseCase;
    }

    @Override
    public Mono<Decks> get() {
        return extractorDecksUseCase.get().flatMap(decks -> {
            System.out.println("decks.getDeck_id() = " + decks.getDeck_id());
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.DECK_ROUTING_KEY, gson.toJson(decks));
            return Mono.just(decks);
        });
    }
}
