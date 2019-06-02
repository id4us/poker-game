package com.practise.poker.app.processor;

import com.practise.poker.app.InvalidHandException;
import com.practise.poker.app.helperUtils.HelperUtils;
import com.practise.poker.app.domain.Card;
import com.practise.poker.app.domain.Hands;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@AllArgsConstructor
@Slf4j
public class CheckHandsImpl implements CheckHands {

    public Hands getHand(List<Card> cards)  {

        if(cards.size()!=5){
            throw new InvalidHandException("invalid number of cards");
        }

        if (HelperUtils.checkStraightFlush(cards)) return Hands.STRAIGHT;
        else if (HelperUtils.checkFourOfKind(cards)) return Hands.FOUROFKIND;
        else if (HelperUtils.checkFullHouse(cards)) return Hands.FULLHOUSE;


        return Hands.NOHANDS;
    }





}
