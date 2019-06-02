package com.practise.poker.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Card {

    private int number;
    private Suit suit;


}
