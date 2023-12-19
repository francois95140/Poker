package org.example;

import java.util.List;

public class PckerHand {
    int number ;

    public static void setMycardliste(List<Card> mycardliste) {
        PckerHand.mycardliste = mycardliste;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static List<Card> getMycardliste() {
        return mycardliste;
    }

    static List<Card> mycardliste;
    public int getNumber() {
        return number;
    }
    public   int getSize(){
        return mycardliste.size();
    }

    public PckerHand(int number, List<Card> mycardliste) {
        this.number = number;
        this.mycardliste = mycardliste;
    }
}
