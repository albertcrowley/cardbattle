package net.bwnj.cardbattle.Engine;

import java.util.ArrayList;
import java.util.List;

public class DeckBuilder {

    public static Deck getOneOfEveryCard() {
        List<Card> cardSet = new ArrayList<Card>();
        cardSet.add(new Card(new CardArchitype("one")));
        cardSet.add(new Card(new CardArchitype("two")));
        cardSet.add(new Card(new CardArchitype("three")));
        cardSet.add(new Card(new CardArchitype("four")));
        Deck d = new Deck(cardSet);
        return d;
    }
}
