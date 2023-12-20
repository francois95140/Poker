package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class Rules {

    int count = 0;

    public String compareCrads(List<Card> cards) {
        if (isStraightFlush(cards)) {
            count = 1;
            return "Straight flush";
        } else if (isFourOfAKind(cards)) {
            count = 2;
            return "Four of a kind";
        } else if (isFullHouse(cards)) {
            count = 3;
            return "Full house";
        } else if (isFlush(cards)) {
            count = 4;
            return "Flush";
        } else if (isStraight(cards)) {
            return "Straight";
        } else if (isThreeOfAKind(cards,false)) {
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

    public Card isHighCard(List<Card> cards) {
        Card carteMax = cards.get(0);

        for (Card card : cards) {

            if (card.getCardvalue().getValue() < carteMax.getCardvalue().getValue()) {
                carteMax = card;
            }
        }

        return carteMax;
    }

    public Card isMinCard(List<Card> cards) {
        Card cardMin = cards.get(0);

        for (Card card : cards) {

            if (card.getCardvalue().getValue() > cardMin.getCardvalue().getValue()) {
                cardMin = card;
            }
        }

        return cardMin;
    }


    public boolean isStraightFlush(List<Card> cards) {
        return isFlush(cards) && isStraight(cards);
    }

    public boolean isFourOfAKind(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                for (int k = j + 1; k < cards.size(); k++) {
                    for (int l = k + 1; l < cards.size(); l++) {
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
        return isThreeOfAKind(cards,true ) && isPair(cards);
    }

    public boolean isFlush(List<Card> cards) {
        int countS = 0;
        int countC = 0;
        int countH = 0;
        int countD = 0;
        for (Card card : cards) {
            if (card.getSuit() == Suit.S) {
                countS = countS + 1;
            } else if (card.getSuit() == Suit.C) {
                countC = countC + 1;
            } else if (card.getSuit() == Suit.H) {
                countH = countH + 1;
            } else if (card.getSuit() == Suit.D) {
                countD = countD + 1;
            }
        }
        return countC == 5 || countS == 5 || countD == 5 || countH == 5;
    }

    public boolean isStraight(List<Card> cards) {
        int min = isMinCard(cards).getCardvalue().getValue();
        int max = isHighCard(cards).getCardvalue().getValue();
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(i).getCardvalue().getValue() == cards.get(j).getCardvalue().getValue()) {
                    return false;
                }
            }
        }
        return min - max == 4;
    }

    public boolean isThreeOfAKind(List<Card> cards , boolean delet) {
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                for (int k = j + 1; k < cards.size(); k++) {
                    if (cards.get(i).getCardvalue() == cards.get(j).getCardvalue() && cards.get(j).getCardvalue() == cards.get(k).getCardvalue()) {
                        if (delet){
                            cards.remove(i);
                            cards.remove(j);
                            cards.remove(k);
                        }
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean isTwoPairs(List<Card> cards) {
        int count = 0;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(i).getCardvalue() == cards.get(j).getCardvalue()) {
                    count++;
                    if (count == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isPair(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(i).getCardvalue() == cards.get(j).getCardvalue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int winnerHand(PckerHand playerOne, PckerHand playerTwo) {
        compareCrads(playerOne.mycardliste);
        int indiceOne = count;
        compareCrads(playerTwo.mycardliste);
        int indiceTwo = count;
        if (indiceOne < indiceTwo) {
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