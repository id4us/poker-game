package com.practise.poker.app.processor;

import com.practise.poker.app.domain.Game;
import com.practise.poker.app.domain.Hands;
import com.practise.poker.app.domain.Player;

import java.util.Comparator;
import java.util.List;

public class GameImpl implements Game {
    CheckHandsImpl checkHands= new CheckHandsImpl();

    @Override
    public Player findWinner(List<Player> players) {

        players.stream().forEach(player -> {
            player.setRank(getRank(checkHands.getHand(player.getCardList())));
        });

        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
               return o1.getRank() - o2.getRank();
            }
        });


        return players.get(0);


    }

    private int getRank(Hands hand) {

        switch (hand) {
            case STRAIGHT:
               return 1;
            case FOUROFKIND:
                return 2;
            case FULLHOUSE:
                return 3;
            case NOHANDS:
                return 4;
            default:
                return 5;

        }

    }
}
