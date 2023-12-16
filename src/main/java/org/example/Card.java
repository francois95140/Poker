package org.example;

public class Card {
    CardValue cardvalue;
    Suit suit;

    public Card(CardValue cardvalue, Suit suit) {
        this.cardvalue = cardvalue;
        this.suit=suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValue getCardvalue() {
        return cardvalue;
    }
}
