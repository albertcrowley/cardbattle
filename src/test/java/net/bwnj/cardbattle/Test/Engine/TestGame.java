package net.bwnj.cardbattle.Test.Engine;

import net.bwnj.cardbattle.Engine.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestGame {
    Pile d1 = DeckBuilder.getFiveCardDeck();
    Pile d2 = DeckBuilder.getStandardPlayingCardDeck();

    Game getOddGame() {
        Location l1 = new Location("hand", d1);
        Location l2 = new Location("drawpile", d2);
        return new Game(List.of(new Location[]{l1, l2}));
    }

    @Test
    void testLocationByName() {
        Game g = getOddGame();

        Location hand = g.get("hand");
        Assertions.assertEquals(hand.Cards, d1);
    }

    @Test
    void testDrawCardUseCase() {
        Game g = getOddGame();
        g.getLocationByName("drawpile").getCards().shuffle();
        Card top = g.get("drawpile").Cards.get(0);

        System.out.println(top);

        int handCount = g.get("hand").Cards.size();
        int drawpileCount = g.get("drawpile").Cards.size();
        Card topCard = g.get("drawpile").Cards.get(0);

        int moved = g.moveCards(1, "drawpile", "hand");
        Assertions.assertEquals(moved, 1);

        Assertions.assertEquals(handCount + 1, g.get("hand").Cards.size());
        Assertions.assertEquals( drawpileCount - 1, g.get("drawpile").Cards.size());
        Assertions.assertSame(topCard, g.get("hand").Cards.get(0));
    }

    @Test
    void testMoveSpecificCard() {
        // test taking a card out of the middle of your hand and putting it on the drawpile
        Game g = getOddGame();
        Card midCard = g.get("hand").Cards.get(2);

        System.out.println(midCard);

        int handCount = g.get("hand").Cards.size();
        int drawpileCount = g.get("drawpile").Cards.size();

        boolean moved = g.moveSpecificCard(2, "hand", "drawpile");
        Assertions.assertTrue(moved);

        Assertions.assertEquals(handCount - 1, g.get("hand").Cards.size());
        Assertions.assertEquals( drawpileCount + 1, g.get("drawpile").Cards.size());
        Assertions.assertSame(midCard, g.get("drawpile").Cards.get(0));
    }

    @Test
    void testCantMoveTooManyCards() {
        Game g = getOddGame();
        Integer moved = g.moveCards(99999, "drawpile", "hand");
        Assertions.assertNull(moved);

        moved = g.moveCards(g.get("drawpile").Cards.size() + 1, "drawpile", "hand");
        Assertions.assertNull(moved);

        Integer expected = g.get("drawpile").Cards.size();
        moved = g.moveCards(g.get("drawpile").Cards.size(), "drawpile", "hand");
        Assertions.assertEquals(expected, moved);

        g = getOddGame();

        boolean bool = g.moveSpecificCard(9999, "hand", "drawpile");
        Assertions.assertFalse(bool);

        bool = g.moveSpecificCard(g.get("hand").Cards.size(), "hand", "drawpile");
        Assertions.assertFalse(bool);

        bool = g.moveSpecificCard(g.get("hand").Cards.size()-1, "hand", "drawpile");
        Assertions.assertTrue(bool);

    }

}