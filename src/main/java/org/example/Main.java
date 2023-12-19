package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         Card card1 = new Card(CardValue.TWO, Suit.C);
        Card card2 = new Card(CardValue.THREE, Suit.D);
        //...... ou demander a l'utilisateur je sais pas exactement ce quon doit faire
         List<Card> pokerHandCards = Arrays.asList(card1, card2);
        PckerHand pokerHand = new PckerHand(1, pokerHandCards);

         Rules rules = new Rules();
        String result = rules.CompareCrads(PckerHand.getMycardliste());

         System.out.println("Result: " + result);
    }
}