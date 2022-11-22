package net.bwnj.cardbattle.Test.Engine;

import net.bwnj.cardbattle.Engine.Pile;
import net.bwnj.cardbattle.Engine.DeckBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDeck {

    @Test
    void decksHaveOrder() {
        Pile d1 = DeckBuilder.getStandardPlayingCardDeck();
        Pile d2 = DeckBuilder.getStandardPlayingCardDeck();
        for(int i =0; i < 52; i++) {
            Assertions.assertEquals(d1.get(i).toString(), d2.get(i).toString());
        }
    }

    @Test
    void shuffle() {
        Pile d1 = DeckBuilder.getStandardPlayingCardDeck();
        Pile d2 = DeckBuilder.getStandardPlayingCardDeck();

        // same order before shuffle
        for(int i=0; i < d2.size(); i++) {
            Assertions.assertEquals(d1.get(i).toString(), d2.get(i).toString());
        }

        d2.shuffle();

        // different order after shuffle
        boolean isEqual = true;
        for(int i=0; i < d2.size(); i++) {
            if ( ! d1.get(i).toString().equals(d2.get(i).toString())) {
                isEqual = false;
            }
        }
        Assertions.assertFalse(isEqual);
    }
}