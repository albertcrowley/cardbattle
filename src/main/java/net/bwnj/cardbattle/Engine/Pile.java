package net.bwnj.cardbattle.Engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pile extends ArrayList<Card> {
    public String Name;

    public Pile() {
        this.clear();
    }

    public Pile(List<Card> cards) {
        this.clear();
        this.addAll(cards);
    }

    public Pile(List<Card> cards, String name) {
        this.Name = name;
        this.clear();
        this.addAll(cards);
    }

    public void shuffle() {
        Collections.shuffle(this);
    }

}
