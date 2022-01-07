package com.publishercardgame.app.application.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String DECK_QUEUE = "queue.deck";
    public static final String DRAWCARD_QUEUE = "queue.drawcard";
    public static final String EXCHANGE = "exchange";
    public static final String DECK_ROUTING_KEY = "routingkey.deck";
    public static final String DRAWCARD_ROUTING_KEY = "routingkey.drawcard";


    @Bean
    public Queue queueDeck() {
        return new Queue(DECK_QUEUE, true);
    }

    @Bean
    public Queue queueDrawCard() {
        return new Queue(DRAWCARD_QUEUE, true);
    }

    @Bean
    public TopicExchange getExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingDeckQueue(Queue queueDeck, TopicExchange exchange) {
        return BindingBuilder.bind(queueDeck).to(exchange).with(DECK_ROUTING_KEY);
    }

    @Bean
    public Binding bindingDrawCardQueue(Queue queueDrawCard, TopicExchange exchange) {
        return BindingBuilder.bind(queueDrawCard).to(exchange).with(DRAWCARD_ROUTING_KEY);
    }
}
