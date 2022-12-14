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

    @Test
    void baseMonsterDeckTest() {
        Pile monsters = DeckBuilder.getBaseMonsterDeck();

        Assertions.assertTrue( monsters.size() > 5);
        Assertions.assertFalse(monsters.get(0).Architype.Name.isBlank());
        Assertions.assertEquals(monsters.get(0).Architype.Name, "Goblin");
    }

    @Test
    void randoDeckTest() {
        Pile monsters = DeckBuilder.getRandoDeck();

        System.out.println(monsters);

        Assertions.assertTrue( monsters.size() > 5);
        Assertions.assertFalse(monsters.get(0).Architype.Name.isBlank());
        Assertions.assertTrue(monsters.get(1).Architype.Power > 0);
        Assertions.assertTrue(monsters.get(2).Architype.Toughness > 0);
        Assertions.assertTrue(monsters.get(3).Architype.Cost > 0);


    }


}