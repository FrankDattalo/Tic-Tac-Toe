package TickTackToe;

import java.util.Scanner;

/**
 * Created by fjdat on 3/28/2016.
 */
public class TickTackToe {

    public static boolean beginsWithY(String input) {
        return input != null && input.length() > 0 && (input.charAt(0) == 'y' || input.charAt(0) == 'Y');
    }

    public static void logicLoop(Node gameState) {
        /*
        while game is not over
            if is players move
                ask player for move
                update board
                check if win
                    print error
            else
                get move with highest utility
                update board
                check if win
            end
            display board
       end
         */
    }

    public static Position getUserInput(Scanner in, Node gameState) {
        // validate user input, and return player decision
        return Position.Eight;
    }

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to my tic-tac-toe playing program!");
        System.out.println("This program will never lose to a human player!");
        String input;
        do {
            System.out.print("Would you like to go first? (y/n) > ");
            input = in.nextLine();
            if (beginsWithY(input)) {
                // get player input
                // build board based off of player input
                // pass board state to logic loop that will run game
            } else {
                // build board based off of computer decision
                // pass board state to logic loop that will run game
            }
            System.out.print("Would you like to play again? (y/n) > ");
            input = in.nextLine();
        } while (beginsWithY(input));
    }
}
