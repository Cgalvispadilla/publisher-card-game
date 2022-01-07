package com.publishercardgame.app.domain.models;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrawCard {
    private boolean success;
    private List<Cards> cards;
    private String deck_id;
    private String remaining;
}
