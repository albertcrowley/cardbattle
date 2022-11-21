package net.bwnj.cardbattle.Engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck extends ArrayList<Card> {
    public String Name;

    public Deck() {
        this.clear();
    }

    public Deck(List<Card> cards) {
        this.clear();
        this.addAll(cards);
    }

    public Deck(List<Card> cards, String name) {
        this.Name = name;
        this.clear();
        this.addAll(cards);
    }

    public void shuffle() {
        Collections.shuffle(this);
    }

}
