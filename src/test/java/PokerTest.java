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
    public void test(){
        List<Card> cardlisteOne = Arrays.asList(new Card(CardValue.JACK, Suit.H),new Card(CardValue.ACE,Suit.D),new Card(CardValue.THREE,Suit.C),new Card(CardValue.FOUR,Suit.S),new Card(CardValue.FIVE,Suit.D));

        PckerHand playerOne = new PckerHand(1, cardlisteOne);

        Assert.assertEquals(playerOne.getSize(),5);
    }


}
