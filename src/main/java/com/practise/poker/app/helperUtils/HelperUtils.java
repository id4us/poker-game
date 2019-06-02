package com.practise.poker.app.helperUtils;

import com.practise.poker.app.processor.RankComparator;
import com.practise.poker.app.domain.Card;
import com.practise.poker.app.domain.Suit;

import java.util.*;
import java.util.stream.Collectors;

public class HelperUtils {

    private static RankComparator rankComparator= new RankComparator();
    private static int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private static List<Suit> suitList = new ArrayList<>(EnumSet.allOf(Suit.class));

//    static Map<Integer, Integer> sortedByRank = new HashMap<>();



    private static Map<Integer, Integer> countRankCards(List<Card> cards) {
         Map<Integer, Integer> rankMap = new HashMap<>();
        cards.sort(rankComparator);
        cards.stream().forEach(s -> {
                    rankMap.putIfAbsent(s.getNumber(), 0);
                    if (Arrays.binarySearch(ranks, s.getNumber()) >= 0) {
                        rankMap.put(s.getNumber(), rankMap.get(s.getNumber()) + 1);
                    }
                }
        );

        return rankMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

    }

    private static Map<Suit, Integer> sortBySuit(List<Card> cards) {
     Map<Suit, Integer> suitMapSorted = new HashMap<>();
        cards.stream().forEach(s -> {
            suitMapSorted.putIfAbsent(s.getSuit(), 0);
            if (suitMapSorted.containsKey(s.getSuit())) {
                suitMapSorted.put(s.getSuit(), suitMapSorted.get(s.getSuit()) + 1);
            }
        });
        return suitMapSorted;
    }


    public static boolean checkStraightFlush(List<Card> cards) {
        Map<Suit, Integer> sortedByRank = sortBySuit(cards);
        if (sortedByRank.containsValue(5)) return true;
        else return false;
    }

    public static boolean checkFourOfKind(List<Card> cards) {
        Map<Integer, Integer> sortedByRank = countRankCards(cards);
        if (sortedByRank.containsValue(4))
            return true;
        else {
            return false;
        }
    }
    public static boolean checkFullHouse(List<Card> cards) {

        Map<Integer, Integer> sortedMapByRank = countRankCards(cards);
        if (sortedMapByRank.containsValue(3) && sortedMapByRank.containsValue(2))
            return true;
        else {
            return false;
        }
    }


}
