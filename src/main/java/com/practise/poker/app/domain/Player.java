package com.practise.poker.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Player {

    private String name ;
    private List<Card> cardList;
    @Setter
    private int rank;

}
