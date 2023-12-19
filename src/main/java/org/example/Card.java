package org.example;

public class Card {
    CardValue cardvalue;
    Suit suit;
    Color color ;

    public Card(CardValue cardvalue, Suit suit, Color color ) {
        this.cardvalue = cardvalue;
        this.suit=suit;
        this.color = color;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValue getCardvalue() {
        return cardvalue;
    }
    public void setCardvalue(CardValue cardvalue) {
        this.cardvalue = cardvalue;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    public Color getColor() {
        return color;
    }
}
