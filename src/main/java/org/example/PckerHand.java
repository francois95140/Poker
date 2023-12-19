package org.example;

import java.util.ArrayList;
import java.util.List;

public class PckerHand {
    int number ;
    List<Card> mycardliste;
    public int getNumber() {
        return number;
    }
    public int getSize (){
        return mycardliste.size();
    }

    public PckerHand(int number, List<Card> mycardliste) {
        this.number = number;
        this.mycardliste = mycardliste;
    }
}
