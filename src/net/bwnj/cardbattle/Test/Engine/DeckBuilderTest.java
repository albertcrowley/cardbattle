package net.bwnj.cardbattle.Test.Engine;

import net.bwnj.cardbattle.Engine.Deck;
import net.bwnj.cardbattle.Engine.DeckBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeckBuilderTest {

    @Test
    void getOneOfEveryCard() {
        Assertions.assertTrue(DeckBuilder.getOneOfEveryCard().size() > 1, "Deckbuilder.getOneOfEveryCard should return more than 1 card");
    }

    @Test
    void standardDeckTest52Cards() {
        Deck standardDeck = DeckBuilder.getStandardPlayingCardDeck();
        Assertions.assertEquals(52, standardDeck.size());
    }

    @Test
    void standardDeckTestSuits() {
        Deck standardDeck = DeckBuilder.getStandardPlayingCardDeck();
        for (String suit : new String[] {"Clubs", "Hearts", "Spades", "Diamonds"}) {
            Boolean res = standardDeck.stream().map(str-> str.toString().contains(suit) ).reduce(false,  (a,b) -> a||b );
            Assertions.assertTrue(res, "there should be %s in the deck, I only have %s".formatted(suit, standardDeck));
        }
    }



}