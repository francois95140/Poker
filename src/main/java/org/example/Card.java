package org.example;

public class Card {
    CardValue cardvalue;
    Suit suit;
    Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Card(CardValue cardvalue, Suit suit, Color color) {
        this.cardvalue = cardvalue;
        this.suit=suit;
        this.color = color;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setCardvalue(CardValue cardvalue) {
        this.cardvalue = cardvalue;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValue getCardvalue() {
        return cardvalue;
    }
}
