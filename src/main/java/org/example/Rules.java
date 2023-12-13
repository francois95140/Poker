package org.example;

import java.util.List;

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

        return false;
    }
    public boolean isFourOfAKind(List<Card> cards){

        return false;
    }
    public boolean isFullHouse(List<Card> cards){

        return false;
    }
    public boolean isFlush(List<Card> cards){

        return false;
    }
    public boolean isStraight(List<Card> cards){

        return false;
    }
    public boolean isThreeOfAKind(List<Card> cards){

        return false;
    }
    public boolean isTwoPairs(List<Card> cards){

        return false;
    }
    public boolean isPair(List<Card> cards){

        return false;
    }
}
