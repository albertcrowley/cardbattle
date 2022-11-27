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

    static CardArchitype architypeHelper (String name, int power) {
        CardArchitype ca = new CardArchitype(name);
        ca.Power = power;
        return ca;
    }

    public static Pile getStandardPlayingCardDeck() {
        List<Card> cardSet = new ArrayList<>();
        for (String suit : new String[]{"Hearts", "Spades", "Diamonds", "Clubs"}) {
            cardSet.add(new Card (architypeHelper("Ace of %s".formatted(suit), 1 )));
            cardSet.add(new Card (architypeHelper("King of %s".formatted(suit), 13 )));
            cardSet.add(new Card (architypeHelper("Queen of %s".formatted(suit), 12 )));
            cardSet.add(new Card (architypeHelper("Jack of %s".formatted(suit), 11 )));
            for (int i=2; i <= 10; i++) {
                CardArchitype ca = new CardArchitype("%s of %s".formatted(i, suit));
                ca.Power = i;
                cardSet.add(new Card(ca));
            }
        }
        return new Pile(cardSet, "Playing Cards");
    }
}
