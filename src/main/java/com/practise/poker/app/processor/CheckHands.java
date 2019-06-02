package com.practise.poker.app.processor;

import com.practise.poker.app.domain.Card;
import com.practise.poker.app.domain.Hands;

import java.util.List;

public interface CheckHands {

     Hands getHand(List<Card> cardsList);


}
