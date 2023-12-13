package org.example;

import java.util.*;

public class Rules {
    public String CompareCrads(List<Card> cards){
        if (isStraightFlush(cards)) {
            return "Straight flush";
        } else if (isFourOfAKind(cards)) {
            return "Four of a kind";
        } else if (isFullHouse(cards)) {
            return "Full house";
        } else if (isFlush(cards)) {
            return "Flush";
        } else if (isStraight(cards)) {
            return "Straight";
        } else if (isThreeOfAKind(cards)) {
            return "Three of a kind";
        } else if (isTwoPairs(cards)) {
            return "Two pairs";
        } else if (isPair(cards)) {
            return "Pair";
        } else {
            return "High card";
        }

    }
    public boolean isStraightFlush(List<Card> cards){

            if ( cards.size() != 5 ) return(false);
            if (isStraight(cards) && isFlush(cards)) return true;
            else return false;

    }
    public boolean isFourOfAKind(List<Card> cards){

        return false;
    }
    public boolean isFullHouse(List<Card> cards){

        return false;
    }
    public boolean isFlush(List<Card> cards){

             Card[] anArray = new Card[cards.size()];

            for (int i = 0; i < anArray.length; i++) {
                anArray[i]=(Card)cards.get(i);
            }

            int count = 0;
            for (int i = 0; i < anArray.length; i++) {
                for (int j = i + 1; j < anArray.length; j++) {
                    if (anArray[i].getSuit()==(anArray[j].getSuit())) {
                        count++;
                    }
                }
            }
        if(count == 10)
            return true;
        else
            return false;
    }
    public boolean isStraight(List<Card> cards){


return false ;
    }
    public boolean isThreeOfAKind(List<Card> cards){

        return false;
    }
    public boolean isTwoPairs(List<Card> cards){
        Set<CardValue> uniqueValues = new HashSet<>();
        Set<CardValue> pairs = new HashSet<>();

        for (Card card : cards) {
            if (!uniqueValues.add(card.getCardvalue())) {
                pairs.add(card.getCardvalue());
            }
        }

        return pairs.size() == 2;

    }
    public boolean isPair(List<Card> cards){

            Set<CardValue> uniqueValues = new HashSet<>();
            Set<CardValue> pairs = new HashSet<>();

            for (Card card : cards) {
                if (!uniqueValues.add(card.getCardvalue())) {
                     pairs.add(card.getCardvalue());
                }
            }

            return pairs.size() == 1;

     }

}
