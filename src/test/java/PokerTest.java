import org.example.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerTest {
    @Test
    public void cardCount(){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.JACK, Suit.H),new Card(CardValue.ACE,Suit.D),new Card(CardValue.THREE,Suit.C),new Card(CardValue.FOUR,Suit.S),new Card(CardValue.FIVE,Suit.D));
        List<Card> cardlisteTow = Arrays.asList(new Card(CardValue.JACK, Suit.H),new Card(CardValue.ACE,Suit.D),new Card(CardValue.THREE,Suit.C),new Card(CardValue.FOUR,Suit.S),new Card(CardValue.FIVE,Suit.D));

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

    @Test
    public void handIsPair(){

        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.ACE, Suit.H),new Card(CardValue.ACE,Suit.D),new Card(CardValue.THREE,Suit.C),new Card(CardValue.FOUR,Suit.S),new Card(CardValue.FIVE,Suit.D));

        Rules rules = new Rules();

        Assert.assertTrue(rules.isPair(cardlisteOne));
    }

    @Test
    public void handIsTwoPair(){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.ACE, Suit.H),new Card(CardValue.ACE,Suit.D),new Card(CardValue.THREE,Suit.C),new Card(CardValue.THREE,Suit.S),new Card(CardValue.FIVE,Suit.D));

        Rules rules = new Rules();

        Assert.assertTrue(rules.isTwoPairs(cardlisteOne));
    }

    @Test
    public void handIsThreeOfAKind (){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.TEN, Suit.H),new Card(CardValue.TEN,Suit.D),new Card(CardValue.TEN,Suit.C),new Card(CardValue.THREE,Suit.S),new Card(CardValue.FIVE,Suit.D));

        Rules rules = new Rules();

        Assert.assertTrue(rules.isThreeOfAKind(cardlisteOne,false));
    }

    @Test
    public void handIsFourOfAKind (){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.SEVEN, Suit.H),new Card(CardValue.TEN,Suit.D),new Card(CardValue.TEN,Suit.C),new Card(CardValue.TEN,Suit.S),new Card(CardValue.FIVE,Suit.D));

        Rules rules = new Rules();

        Assert.assertTrue(rules.isFourOfAKind(cardlisteOne));
    }

    @Test
    public void handCompare (){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.TEN, Suit.H),new Card(CardValue.TEN,Suit.D),new Card(CardValue.TEN,Suit.C),new Card(CardValue.TEN,Suit.S),new Card(CardValue.FIVE,Suit.D));

        Rules rules = new Rules();
        System.out.println("result "+rules.compareCrads(cardlisteOne)+" count "+rules.getCount());
        Assert.assertEquals(rules.compareCrads(cardlisteOne),"Four of a kind");
    }

    @Test
    public void handIsFlush (){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.SEVEN, Suit.H),new Card(CardValue.TEN,Suit.H),new Card(CardValue.TEN,Suit.H),new Card(CardValue.TEN,Suit.H),new Card(CardValue.FIVE,Suit.H));

        Rules rules = new Rules();

        Assert.assertTrue(rules.isFlush(cardlisteOne));
    }

    @Test
    public void handIsHighCard (){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.TWO, Suit.H),new Card(CardValue.THREE,Suit.D),new Card(CardValue.FOUR,Suit.C),new Card(CardValue.FIVE,Suit.H),new Card(CardValue.SIX,Suit.H));

        Rules rules = new Rules();

        Assert.assertEquals(String.valueOf(rules.isHighCard(cardlisteOne).getCardvalue().getValue()),"9");
    }

    @Test
    public void handIsStraight (){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.THREE, Suit.H),new Card(CardValue.FOUR,Suit.D),new Card(CardValue.FIVE,Suit.C),new Card(CardValue.SIX,Suit.H),new Card(CardValue.SEVEN,Suit.H));

        Rules rules = new Rules();

        Assert.assertTrue(rules.isStraight(cardlisteOne));
    }

    @Test
    public void handIsStraightFlush (){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.THREE, Suit.H),new Card(CardValue.FOUR,Suit.H),new Card(CardValue.FIVE,Suit.H),new Card(CardValue.SIX,Suit.H),new Card(CardValue.SEVEN,Suit.H));

        Rules rules = new Rules();

        Assert.assertTrue(rules.isStraightFlush(cardlisteOne));
    }

    @Test
    public void handIsFullHouse (){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.THREE, Suit.H),new Card(CardValue.THREE,Suit.H),new Card(CardValue.THREE,Suit.H),new Card(CardValue.SIX,Suit.H),new Card(CardValue.SIX,Suit.H));

        Rules rules = new Rules();

        Assert.assertTrue(rules.isFullHouse(cardlisteOne));
    }

    @Test
    public void Winner (){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.SEVEN, Suit.H),new Card(CardValue.TEN,Suit.D),new Card(CardValue.TEN,Suit.C),new Card(CardValue.TEN,Suit.S),new Card(CardValue.FIVE,Suit.D));
        List<Card> cardlisteTow = Arrays.asList(new Card(CardValue.ACE, Suit.H),new Card(CardValue.ACE,Suit.D),new Card(CardValue.THREE,Suit.C),new Card(CardValue.THREE,Suit.S),new Card(CardValue.FIVE,Suit.D));

        PckerHand playerOne = new PckerHand(1, cardlisteOne);
        PckerHand playerTow = new PckerHand(2, cardlisteTow);

        Rules rules = new Rules();
        System.out.println(rules.winnerHand(playerOne,playerTow));
        Assert.assertEquals(String.valueOf(rules.winnerHand(playerOne,playerTow)),"1");
    }
}
