package com.practise.poker.app.processor;

import com.practise.poker.app.domain.Card;
import com.practise.poker.app.domain.Hands;
import com.practise.poker.app.domain.Player;
import com.practise.poker.app.domain.Suit;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class GameImplTest {

    private static List<Card> fullHouseHand = new ArrayList<>();
    private static List<Card> fourOfKind = new ArrayList<>();
    private static List<Card> straigthFlushHand = new ArrayList<>();
    private static Player player = new Player("A",straigthFlushHand,0);
    private static Player player2 = new Player("B",fourOfKind,0);

    @Before
    public void setUp(){

        fullHouseHand.add(new Card(1, Suit.CLUBS));
        fullHouseHand.add(new Card(1, Suit.DIAMONDS));
        fullHouseHand.add(new Card(3, Suit.CLUBS));
        fullHouseHand.add(new Card(3, Suit.CLUBS));
        fullHouseHand.add(new Card(1, Suit.SPADE));


        fourOfKind.add(new Card(1, Suit.CLUBS));
        fourOfKind.add(new Card(1, Suit.DIAMONDS));
        fourOfKind.add(new Card(1, Suit.CLUBS));
        fourOfKind.add(new Card(1, Suit.CLUBS));
        fourOfKind.add(new Card(3, Suit.SPADE));


        straigthFlushHand.add(new Card(1, Suit.CLUBS));
        straigthFlushHand.add(new Card(13, Suit.CLUBS));
        straigthFlushHand.add(new Card(4, Suit.CLUBS));
        straigthFlushHand.add(new Card(2, Suit.CLUBS));
        straigthFlushHand.add(new Card(3, Suit.CLUBS));


    }



    @Test
    public void findWinner() {
        GameImpl game = new GameImpl();

        assertThat(game.findWinner(Arrays.asList(player,player2))).isEqualTo(player);

    }
}