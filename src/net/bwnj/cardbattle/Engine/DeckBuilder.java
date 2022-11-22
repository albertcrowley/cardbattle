package net.bwnj.cardbattle.Engine;

import java.util.ArrayList;
import java.util.List;

public class DeckBuilder {

    public static Pile getFiveCardDeck() {
        List<Card> cardSet = new ArrayList<>();
        cardSet.add(new Card(new CardArchitype("one")));
        cardSet.add(new Card(new CardArchitype("two")));
        cardSet.add(new Card(new CardArchitype("three")));
        cardSet.add(new Card(new CardArchitype("four")));
        return new Pile(cardSet);
    }

    public static Pile getStandardPlayingCardDeck() {
        List<Card> cardSet = new ArrayList<>();
        for (String suit : new String[]{"Hearts", "Spades", "Diamonds", "Clubs"}) {
            for (String cname: new String[]{"Ace", "King", "Queen", "Jack"}) {
                CardArchitype ca = new CardArchitype("%s of %s".formatted(cname, suit));
                cardSet.add(new Card(ca));
            }
            for (int i=2; i <= 10; i++) {
                CardArchitype ca = new CardArchitype("%s of %s".formatted(i, suit));
                cardSet.add(new Card(ca));
            }
        }
        return new Pile(cardSet, "Playing Cards");
    }
}
