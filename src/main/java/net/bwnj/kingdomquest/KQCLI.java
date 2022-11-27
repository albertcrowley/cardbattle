package net.bwnj.kingdomquest;

import net.bwnj.cardbattle.Engine.DeckBuilder;
import net.bwnj.cardbattle.Engine.Game;
import net.bwnj.cardbattle.Engine.Location;
import net.bwnj.cardbattle.Engine.Pile;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class KQCLI {

    static Game game;


    static void initGame() {
        Pile p = DeckBuilder.getStandardPlayingCardDeck();

        Location l1 = new Location("hand");
        Location l2 = new Location("drawpile", p);
        Location l3 = new Location("table");
        KQCLI.game = new Game(List.of(new Location[]{l1, l2, l3}));

        game.get("drawpile").Cards.shuffle();
        game.moveCards(5, "drawpile", "hand");
    }

    public static boolean printGameState() {
        System.out.println("Your hand:");
        System.out.println(game.get("hand"));
        System.out.println("\nCards on the table");
        System.out.println(game.get("table"));

        if (game.get("hand").Cards.size() < 1) {
            return false; // game ends
        }

        return true;
    }

    public static Integer getInput() {

        try {
            Scanner in = new Scanner(System.in);

            int a = in.nextInt();
            System.out.println("You entered integer " + a);
            return a;
        } catch(InputMismatchException ime) {
            System.out.println("That wasn't a number, please try again");
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Welcome to 21 Counter");


            initGame();

            while (printGameState()) {
                Integer cardNumber = getInput();
                if (cardNumber != null) {
                    game.moveCards(1, "hand", "table");
                }
            }

            System.out.println("GAME OVER!");
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }

    }
}
