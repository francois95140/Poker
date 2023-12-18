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
        int count = 0;
        while (count <=3){
            if (isPair(cards)){
                count++;
            }
        }

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
        for (int i=0; i < cards.size(); i++) {
            for (int j = i+1; j < cards.size(); j++){
                for (int k = j+1; k < cards.size(); k++) {
                    if (cards.get(i).getCardvalue() == cards.get(j).getCardvalue()) {
                        continue;
                    }
                    if (cards.get(j).getCardvalue()==cards.get(k).getCardvalue()){
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
}
// ça va servir à quoi, qu'est-ce que je veux faire
// comment je peux faire ce que je veux faire
//on prend la 1ere carte, on la compare à la deuxième,etc
// si la 1er est pareil que la 2è on return true
// je rajoute une variable int pair et j'incremente