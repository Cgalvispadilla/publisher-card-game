package com.publishercardgame.app.domain.models;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Decks {
    private boolean success;
    private String deck_id;
    private boolean shuffled;
    private Integer remaining;
}
