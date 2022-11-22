package net.bwnj.cardbattle.Test.Engine;

import net.bwnj.cardbattle.Engine.Pile;
import net.bwnj.cardbattle.Engine.DeckBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDeckBuilder {

    @Test
    void getOneOfEveryCard() {
        Assertions.assertTrue(DeckBuilder.getFiveCardDeck().size() > 1, "Deckbuilder.getOneOfEveryCard should return more than 1 card");
    }

    @Test
    void standardDeckTest52Cards() {
        Pile standardDeck = DeckBuilder.getStandardPlayingCardDeck();
        Assertions.assertEquals(52, standardDeck.size());
    }

    @Test
    void standardDeckTestSuits() {
        Pile standardDeck = DeckBuilder.getStandardPlayingCardDeck();
        for (String suit : new String[] {"Clubs", "Hearts", "Spades", "Diamonds"}) {
            Boolean res = standardDeck.stream().map(str-> str.toString().contains(suit) ).reduce(false,  (a,b) -> a||b );
            Assertions.assertTrue(res, "there should be %s in the deck, I only have %s".formatted(suit, standardDeck));
        }
    }



}