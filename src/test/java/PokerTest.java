import org.example.Card;
import org.example.CardValue;
import org.example.PckerHand;
import org.example.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerTest {
    @Test
    public void cardCount(){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.JACK, Suit.H ),new Card(CardValue.ACE,Suit.D ),new Card(CardValue.THREE,Suit.C),new Card(CardValue.FOUR,Suit.S),new Card(CardValue.FIVE,Suit.D));
        List<Card> cardlisteTow = Arrays.asList(new Card(CardValue.JACK, Suit.H ),new Card(CardValue.ACE,Suit.D ),new Card(CardValue.THREE,Suit.C),new Card(CardValue.FOUR,Suit.S),new Card(CardValue.FIVE,Suit.D));

        PckerHand playerOne = new PckerHand(1, cardlisteOne);
        PckerHand playerTow = new PckerHand(2, cardlisteTow);

        Assert.assertEquals(playerOne.getSize(),5);
        Assert.assertEquals(playerTow.getSize(),5);
    }

    @Test
    public void cardIsDifferent(){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.ACE, Suit.H),new Card(CardValue.ACE,Suit.D),new Card(CardValue.THREE,Suit.C),new Card(CardValue.FOUR,Suit.C),new Card(CardValue.FIVE,Suit.D));

        PckerHand playerOne = new PckerHand(1, cardlisteOne);

        boolean areAllDifferent = true;

        for (int i = 0; i < cardlisteOne.size(); i++) {
            for (int j = i + 1; j < cardlisteOne.size(); j++) {
                //System.out.println(cardlisteOne.get(i).getCardvalue()+" "+cardlisteOne.get(j).getCardvalue() );
                if (cardlisteOne.get(i).getCardvalue().equals(cardlisteOne.get(j).getCardvalue())  && cardlisteOne.get(i).getSuit().equals(cardlisteOne.get(j).getSuit())) {
                    areAllDifferent = false;
                    break;
                }
            }
        }
        Assert.assertTrue(areAllDifferent);
    }

    @Test
    public void handIsDifferent(){

        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.JACK, Suit.H),new Card(CardValue.ACE,Suit.D),new Card(CardValue.THREE,Suit.C),new Card(CardValue.FOUR,Suit.S),new Card(CardValue.FIVE,Suit.D));
        List<Card> cardlisteTow = Arrays.asList(new Card(CardValue.JACK, Suit.D),new Card(CardValue.ACE,Suit.H),new Card(CardValue.THREE,Suit.D),new Card(CardValue.FOUR,Suit.C),new Card(CardValue.FIVE,Suit.S));

        boolean areDifferent = true;

        for (Card cardHandOne : cardlisteOne) {
            for (Card cardHandTow : cardlisteTow) {
                //System.out.println(cardHandOne.getSuit());
                if (cardHandOne.getCardvalue().equals(cardHandTow.getCardvalue()) && cardHandOne.getSuit().equals(cardHandTow.getSuit())) {
                    areDifferent = false;
                    break;
                }
            }
        }

        Assert.assertTrue(areDifferent);
    }
}
