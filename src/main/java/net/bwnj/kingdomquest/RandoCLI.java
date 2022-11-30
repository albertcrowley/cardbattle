package net.bwnj.kingdomquest;

import net.bwnj.cardbattle.Engine.DeckBuilder;
import net.bwnj.cardbattle.Engine.Game;
import net.bwnj.cardbattle.Engine.Location;
import net.bwnj.cardbattle.Engine.Pile;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class RandoCLI {

    static Game game;
    static Integer score;
    static boolean gameOver = false;

    static Random rand = new Random();

    static void initGame() {

        Location l1 = new Location("hand");
        Location l2 = new Location("drawpile", DeckBuilder.getRandoDeck());
        Location l3 = new Location("table");
        Location l4 = new Location("monsters", DeckBuilder.getRandoDeck());
        Location l5 = new Location("field");

        RandoCLI.game = new Game(List.of(new Location[]{l1, l2, l3, l4, l5}));

        game.get("drawpile").Cards.shuffle();
        game.get("monsters").Cards.shuffle();
        game.moveCards(5, "drawpile", "hand");
        game.moveCards(rand.nextInt(2)+1, "monsters", "field");

        score = 0;
    }

    public static boolean printGameState() {
        System.out.println("Your hand:");
        System.out.println(game.get("hand"));
        System.out.println("\nMonsters!");
        System.out.println(game.get("field"));
        System.out.println("\nCards on the table");
        System.out.println(game.get("table"));

        System.out.println("Your score: %d".formatted(score));


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

    static void tick() {
        Integer cardNumber = getInput();
        if (cardNumber != null) {
            game.moveSpecificCard(cardNumber-1, "hand", "table");
            //now draw
            game.moveCards(1,"drawpile", "hand");
        }

        scoreTheGame();
    }

    static void scoreTheGame() {
        score = game.get("table").Cards.stream().map((card) -> card.Architype.Power).reduce(0, (subtotal, i) -> subtotal + i);

        if (score > 21) {
            System.out.println("\nSorry you lost. You went over 21!  \nYour ending score was %d.".formatted(score));
            gameOver = true;
        }

        if (score == 21) {
            System.out.println("\nYOU WIN!  Perfect score of 21");
            gameOver = true;
        }

        if (game.get("hand").Cards.size() < 1) {
            gameOver = true;
        }

    }

    public static void main(String[] args) {
        try {
            System.out.println("Welcome to Rando Battle");


            initGame();

            while ( ! gameOver) {
                printGameState();
                tick();
            }

            System.out.println("GAME OVER!");
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }

    }
}
