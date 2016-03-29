package TickTackToe;

import javafx.geometry.Pos;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by fjdat on 3/28/2016.
 */
public class TickTackToe {

    public static boolean beginsWithY(String input) {
        return input != null && input.length() > 0 && (input.charAt(0) == 'y' || input.charAt(0) == 'Y');
    }

    public static void logicLoop(Scanner in, Node gameState, int turn) {
        boolean isGameOver = gameState.getBoardState().isTerminalCase();
        if(turn > 0) {
            System.out.println("Turn " + turn + ": ");
            gameState.getBoardState().display();
            System.out.println();
        }
        while (!isGameOver) {
            if ( gameState.getBoardState().getPreviousMove().getPlayer() != Player.Human) { // player move
                Position p = getUserInput(in, gameState);
                gameState = gameState.getChildWithAction(new Action(Player.Human, p));
                isGameOver = gameState.getBoardState().isTerminalCase();
                if(isGameOver) {
                    if(gameState.getBoardState().isWinningCase()) {
                        System.out.println("Player wins!");
                        gameState.getBoardState().display();
                        System.out.println();
                    } else {
                        System.out.println("Draw!");
                        gameState.getBoardState().display();
                        System.out.println();
                    }
                    break;
                }
            } else { // computer move
                gameState = gameState.getChildWithHighestUtility();
                isGameOver = gameState.getBoardState().isTerminalCase();
                if(isGameOver) {
                    if(gameState.getBoardState().isWinningCase()) {
                        System.out.println("Computer wins!");
                        gameState.getBoardState().display();
                        System.out.println();
                    } else {
                        System.out.println("Draw!");
                        gameState.getBoardState().display();
                        System.out.println();
                    }
                    break;
                }
            }
            turn++;
            System.out.println("Turn " + turn + ": ");
            gameState.getBoardState().display();
            System.out.println();
        }
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
        int x , y, p;
        boolean flag = false;

        do {
            if(flag) {
                System.out.println("ERROR! INVALID NUMBER!");
            }
            System.out.println("Enter a board position x y such that: ");
            System.out.print("(1 <= x <= 3) and (1 <= y <= 3) > ");
            try {
                x = in.nextInt();
                y = in.nextInt();
            } catch (InputMismatchException e) {
                x = -1;
                y = -1;
            }
            flag = true;
            p = (x - 1) + (((y - 1) % 3) * 3);
        } while(x < 1 || x > 3 || y < 1 || y > 3 || ( gameState != null &&
                !gameState.getBoardState().getOpenPositions().contains(Position.getPosition(p))));

        return Position.getPosition(p);
    }

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to my tic-tac-toe playing program!");
        System.out.println("This program will never lose to a human player if it goes first!");
        String input;
        System.out.print("Would you like to go first? (y/n) > ");
        input = in.nextLine();
        if (beginsWithY(input)) {
            // build board based off of player input
            // pass board state to logic loop that will run game
            Node gameState = new Node(null, null);
            gameState.getBoardState().display();
            gameState = new Node(gameState, new Action(Player.Human, getUserInput(in, null)));
            System.out.println("Building game!...");
            gameState.build();
            logicLoop(in, gameState, 1);
        } else {
            // build board based off of computer decision
            // pass board state to logic loop that will run game
            Node gameState = new Node(null, null);
            System.out.println("Building game!...");
            gameState.build();
            logicLoop(in, gameState, 0);
        }
    }
}
