package net.bwnj.cardbattle.Test.Engine;

import net.bwnj.cardbattle.Engine.Deck;
import net.bwnj.cardbattle.Engine.DeckBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void decksHaveOrder() {
        Deck d1 = DeckBuilder.getStandardPlayingCardDeck();
        Deck d2 = DeckBuilder.getStandardPlayingCardDeck();
        for(int i =0; i < 52; i++) {
            Assertions.assertEquals(d1.get(i).toString(), d2.get(i).toString());
        }
    }

    @Test
    void shuffle() {
        Deck d1 = DeckBuilder.getStandardPlayingCardDeck();
        Deck d2 = DeckBuilder.getStandardPlayingCardDeck();

        // same order before shuffle
        for(int i=0; i < d2.size(); i++) {
            Assertions.assertEquals(d1.get(i).toString(), d2.get(i).toString());
        }

        d2.shuffle();

        // different order after shuffle
        for(int i=0; i < d2.size(); i++) {
            Assertions.assertNotEquals(d1.get(i).toString(), d2.get(i).toString());
        }
    }
}