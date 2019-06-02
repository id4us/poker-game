package com.practise.poker.app.processor;

import com.practise.poker.app.domain.Card;

import java.util.Comparator;

public class RankComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.getNumber()-o2.getNumber();
    }
}
