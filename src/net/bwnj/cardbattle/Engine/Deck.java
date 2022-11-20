package net.bwnj.cardbattle.Engine;

import java.util.ArrayList;
import java.util.List;

public class Deck extends ArrayList<Card> {
    public Deck() {
    }
    public Deck(List<Card> cards) {
        this.clear();
        for (Card c : cards) {
            this.add(c);
        }
    }


}
