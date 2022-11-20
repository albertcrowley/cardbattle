package net.bwnj.cardbattle.Engine;

import java.util.ArrayList;
import java.util.List;

public class Location {
    public String Name;
    public Deck Cards;

    public Location(String name) {
        this.Name = name;
        this.Cards = new Deck();
    }


    public Deck getCards() {
        return Cards;
    }

    public void setCards(Deck cards) {
        Cards = cards;
    }


    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Location: %s\n".formatted(Name));
        for (Card c : this.Cards) {
            sb.append("  %s\n".formatted(c));
        }
        return sb.toString();
    }


}
