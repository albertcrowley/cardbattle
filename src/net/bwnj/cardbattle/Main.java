package net.bwnj.cardbattle;

import net.bwnj.cardbattle.Engine.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Game game;

    public static void main(String[] args) {
        System.out.println("Hi world!");

        List<Location> l = new ArrayList<Location>();
        Location deck = new Location("deck");
        deck.Cards = DeckBuilder.getOneOfEveryCard();

        l.add(deck);
        l.add(new Location("hand"));

        Main.game = new Game(l);
        Main.printState();

    }

    public static void printState() {
        for (Location location : Main.game.Locations) {
            System.out.println(location.toString());
        }
    }
}