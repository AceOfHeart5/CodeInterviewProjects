import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        boolean running = true;
        System.out.println("Welcome to Tic Tac Toe!");
        while (running) {
            boolean player1 = false; // boolean for player 1 vs 2. True for player 1, false for player 2.
            boolean playing = true;
            while (playing) {
                player1 = !player1;
                game.takeTurn(player1);
                if (game.checkVictory(true)) {
                    victoryMsg("Player 1");
                    playing = false;
                }
                if (game.checkVictory(false)) {
                    victoryMsg("Player 2");
                    playing = false;
                }
                if (playing && game.boardFull()) {
                    System.out.println("The game is a draw.");
                    playing = false;
                }
            }
            game.printBoard();
            System.out.println("Play again? Y / N");
            if (getYorN()) game.reset();
            else running = false;
        }
        System.out.println("Thanks for playing!");
    }

    private static void victoryMsg(String name) {
        System.out.println(name + " is the winner!");
    }

    // returns true if user enters y, false if user enters n
    private static boolean getYorN() {
        Scanner keyboard = new Scanner(System.in);
        boolean result = false;
        boolean valid = false;
        while (!valid) {
            String answer = keyboard.nextLine();
            if (answer.length() != 1) {
                System.out.println("Please enter only Y or N");
            } else {
                if (answer.equalsIgnoreCase("y")) {
                    valid = true;
                    result = true;
                }
                if (answer.equalsIgnoreCase("n")) {
                    valid = true;
                    result = false;
                }
                if (!valid) System.out.println("Please enter only Y or N");
            }
        }
        return result;
    }
}
