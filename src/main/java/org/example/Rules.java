package org.example;

import java.util.*;

public class Rules {
    public String CompareCrads(List<Card> cards){
        if (cards.size() != 5) {
            throw new IllegalArgumentException("A poker hand must have exactly 5 cards.");
        }
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
    public String CompareHands(PckerHand blackHand, PckerHand whiteHand) {
        String blackResult = CompareCrads(blackHand.getMycardliste());
        String whiteResult = CompareCrads(whiteHand.getMycardliste());

        if (blackResult.equals(whiteResult)) {
            return "Tie.";
        } else {
            return determineWinner(blackResult, whiteResult);
        }
    }
    private String determineWinner(String blackResult, String whiteResult) {

        int resultComparison = blackResult.compareTo(whiteResult);

        if (resultComparison < 0) {
            return "Black wins. - with " + blackResult;
        } else if (resultComparison > 0) {
            return "White wins. - with " + whiteResult;
        } else {
            return "Tie. - with " + blackResult;
        }
    }
    public boolean isStraightFlush(List<Card> cards) {
             // Vérifier d'abord si c'est un Flush
            if (!isFlush(cards)) {
                return false;
            }

            // Vérifier si les valeurs sont consécutives
            int minValue = cards.get(0).getCardvalue().ordinal();
            for (int i = 1; i < cards.size(); i++) {
                if (cards.get(i).getCardvalue().ordinal() != minValue + i) {
                    return false;
                }
            }

            return true;
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
    public boolean isFullHouse(List<Card> cards) {


        // Compter les occurrences de chaque valeur
        Map<CardValue, Integer> valueCounts = new HashMap<>();
        for (Card card : cards) {
            valueCounts.put(card.getCardvalue(), valueCounts.getOrDefault(card.getCardvalue(), 0) + 1);
        }

        // Vérifier si on a trois cartes de même valeur et deux autres formant une paire
        boolean threeOfAKind = false;
        boolean pair = false;

        for (int count : valueCounts.values()) {
            if (count == 3) {
                threeOfAKind = true;
            } else if (count == 2) {
                pair = true;
            }
        }

        return threeOfAKind && pair;
    }


    public boolean isFlush(List<Card> cards) {
            // Récupére le suit de la première carte
            Suit firstCardSuit = cards.get(0).getSuit();

            // Vérifier si toutes les cartes ont la même suit que la premiere carte
            for (Card card : cards) {
                if (card.getSuit() != firstCardSuit) {
                    return false;
                }
            }

            return true;

    }

    public boolean isStraight(List<Card> cards) {
        // Vérifier si les valeurs sont consécutives
        int minValue = cards.get(0).getCardvalue().ordinal();
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getCardvalue().ordinal() != minValue + i) {
                return false;
            }
        }

        return true;
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