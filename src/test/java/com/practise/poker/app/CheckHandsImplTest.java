package com.practise.poker.app;

import com.practise.poker.app.domain.Card;
import com.practise.poker.app.domain.Hands;
import com.practise.poker.app.domain.Suit;
import com.practise.poker.app.processor.CheckHandsImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckHandsImplTest {


  @Test
  public void testFullHouse() {
    //Three of a kind with a pair.
    CheckHandsImpl checkRank = new CheckHandsImpl();

    List<Card> cards = new ArrayList<Card>();

    cards.add(new Card(1, Suit.CLUBS));
    cards.add(new Card(1, Suit.DIAMONDS));
    cards.add(new Card(3, Suit.CLUBS));
    cards.add(new Card(3, Suit.CLUBS));
    cards.add(new Card(1, Suit.SPADE));

    assertThat(checkRank.getHand(cards)).isEqualTo(Hands.FULLHOUSE);

  }

  @Test
  public void fourofKind() {
    CheckHandsImpl checkRank = new CheckHandsImpl();
    List<Card> cards = new ArrayList<>();
    cards.add(new Card(1, Suit.CLUBS));
    cards.add(new Card(1, Suit.DIAMONDS));
    cards.add(new Card(1, Suit.CLUBS));
    cards.add(new Card(1, Suit.CLUBS));
    cards.add(new Card(3, Suit.SPADE));

    assertThat(checkRank.getHand(cards)).isEqualTo(Hands.FOUROFKIND);
  }

  @Test
  public void testStraightFlush() {
    CheckHandsImpl checkRank = new CheckHandsImpl();
    List<Card> cards = new ArrayList<>();
    cards.add(new Card(1, Suit.CLUBS));
    cards.add(new Card(13, Suit.CLUBS));
    cards.add(new Card(4, Suit.CLUBS));
    cards.add(new Card(2, Suit.CLUBS));
    cards.add(new Card(3, Suit.CLUBS));

    assertThat(checkRank.getHand(cards)).isEqualTo(Hands.STRAIGHT);
  }

  @Test(expected = InvalidHandException.class)
  public void testException() {

    CheckHandsImpl checkRank = new CheckHandsImpl();
    List<Card> cards = new ArrayList<>();
    checkRank.getHand(cards);
  }

//    @Test
//    public void testOnePair() {
//        CheckHandsImpl checkRank = new CheckHandsImpl();
//        List<Card> cards = new ArrayList<>();
//        cards.add(new Card(1, Suit.CLUBS, Color.RED));
//        cards.add(new Card(13, Suit.CLUBS, Color.RED));
//        cards.add(new Card(1, Suit.HEART, Color.RED));
//        cards.add(new Card(2, Suit.CLUBS, Color.RED));
//        cards.add(new Card(3, Suit.CLUBS, Color.RED));
//
//        assertThat(checkRank.getHand(cards)).isEqualTo(Hands.STRAIGHT);
//    }


}