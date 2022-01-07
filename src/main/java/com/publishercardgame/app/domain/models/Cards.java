package com.publishercardgame.app.domain.models;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cards {
    private String image;
    private String value;
    private String suit;
    private String coder;
}
