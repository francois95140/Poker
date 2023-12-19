package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class Rules {

    int count = 0;

    public String compareCrads(List<Card> cards){
        if (isStraightFlush(cards)) {
            count =
                    31;
            return "Straight flush";
        } else if (isFourOfAKind(cards)) {
            count = 2;
            return "Four of a kind";
        } else if (isFullHouse(cards)) {
            count = 3;
            return "Full house";
        } else if (isFlush(cards)) {
            count = 4 ;
            return "Flush";
        } else if (isStraight(cards)) {
            return "Straight";
        } else if (isThreeOfAKind(cards)) {
            count = 6;
            return "Three of a kind";
        } else if (isTwoPairs(cards)) {
            count = 7;
            return "Two pairs";
        } else if (isPair(cards)) {
            count = 8;
            return "Pair";
        } else {
            count = 9;
            return "High card";
        }


    }
    public boolean isStraightFlush(List<Card> cards) {
         cards.sort(Comparator.comparingInt(card -> card.getCardvalue().ordinal()));

         for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).getCardvalue().ordinal() != cards.get(i).getCardvalue().ordinal() + 1 ||
                    cards.get(i + 1).getSuit() != cards.get(i).getSuit()) {
                return false;
            }
        }

        return true;
    }

    public boolean isFourOfAKind(List<Card> cards){
        for (int i=0; i < cards.size(); i++) {
            for (int j = i+1; j < cards.size(); j++){
                for (int k = j+1; k < cards.size(); k++) {
                    for (int l = k+1 ; l < cards.size(); l++){
                        if (cards.get(i).getCardvalue() == cards.get(j).getCardvalue() && cards.get(j).getCardvalue() == cards.get(k).getCardvalue()) {
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }

    public boolean isFullHouse(List<Card> cards) {
        Map<CardValue, Integer> valueCounts = new HashMap<>();

        for (Card card : cards) {
            valueCounts.put(card.getCardvalue(), valueCounts.getOrDefault(card.getCardvalue(), 0) + 1);
        }

        boolean hasThreeOfAKind = false;
        boolean hasPair = false;

        for (int count : valueCounts.values()) {
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasPair = true;
            }
        }

        return hasThreeOfAKind && hasPair;
    }

    public boolean isFlush(List<Card> cards) {
        Color firstColor = null;

        for (Card card : cards) {
            if (firstColor == null || firstColor == card.getColor()) {
                firstColor = card.getColor();
            } else {

                return false;
            }
        }

        return true;
    }

    public boolean isStraight(List<Card> cards) {

        cards.sort(Comparator.comparingInt(card -> card.getCardvalue().ordinal()));


        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).getCardvalue().ordinal() != cards.get(i).getCardvalue().ordinal() + 1) {
                return false;
            }
        }
        return true;
    }
    public boolean isThreeOfAKind(List<Card> cards){
        for (int i=0; i < cards.size(); i++) {
            for (int j = i+1; j < cards.size(); j++){
                for (int k = j+1; k < cards.size(); k++) {
                    if (cards.get(i).getCardvalue() == cards.get(j).getCardvalue() && cards.get(j).getCardvalue() == cards.get(k).getCardvalue()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public boolean isTwoPairs(List<Card> cards){
        int count = 0;
        for (int i= 0; i < cards.size(); i ++) {
            for (int j = i+1; j < cards.size(); j++){
                if (cards.get(i).getCardvalue()==cards.get(j).getCardvalue()){
                    count ++;
                    if (count == 2){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isPair(List<Card> cards){
        for ( int i=0; i < cards.size(); i++) {
            for ( int j=i+1; j < cards.size(); j++) {
                if (cards.get(i).getCardvalue()==cards.get(j).getCardvalue()){
                    return true;
                }
            }
        }
        return false;
    }

    public int winnerHand (PckerHand playerOne , PckerHand playerTwo){
        compareCrads(playerOne.mycardliste);
        int indiceOne = count;
        compareCrads(playerTwo.mycardliste);
        int indiceTwo = count;
        if ( indiceOne < indiceTwo){
            return playerOne.number;
        }
        return playerTwo.number;
    }

    public int getCount() {
        return count;
    }
}
// ça va servir à quoi, qu'est-ce que je veux faire
// comment je peux faire ce que je veux faire
//on prend la 1ere carte, on la compare à la deuxième,etc
// si la 1er est pareil que la 2è on return true
// je rajoute une variable int pair et j'incremente