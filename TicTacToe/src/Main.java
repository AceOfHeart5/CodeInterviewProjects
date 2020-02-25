import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        boolean player1 = true; // boolean for player 1 vs 2.
        boolean playing = true;
        while (playing) {
            while (!game.boardFull()) {
                game.takeTurn(player1);
                player1 = !player1;
            }
            boolean winner = false;
            if (game.checkVictory(true)) {
                victoryMsg("Player 1");
                winner = true;
            }
            if (game.checkVictory(true)) {
                victoryMsg("Player 2");
                winner = true;
            }
            if (!winner) System.out.println("The game was a draw");
            game.printBoard();
            System.out.println("Play again? Y / N");

        }
    }

    private static void victoryMsg(String name) {
        System.out.println(name + " is the winner!");
    }

    private static boolean getYorN() {
        Scanner keyboard = new Scanner(System.in);
        boolean result = false;
        String answer = "";
        boolean valid = false;
        while (!valid) {
            valid = true;
            answer = keyboard.nextLine();
            if (answer.length() != 1) {
                System.out.println("Please enter only Y or N");
                valid = false;
            }
            
        }
        return result;
    }
}
