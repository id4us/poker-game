package com.practise.poker.app.domain;

import com.practise.poker.app.processor.CheckHandsImpl;

import java.util.List;

public interface Game {

        Player findWinner(List<Player> players);

}
