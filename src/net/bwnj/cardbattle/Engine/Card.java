package net.bwnj.cardbattle.Engine;

public class Card {

    public CardArchitype Architype;

    public Card(CardArchitype cardArchitype) {
        this.Architype = cardArchitype;
    }

    public String toString() {
        return "instance of " + Architype.toString();
    }


}
