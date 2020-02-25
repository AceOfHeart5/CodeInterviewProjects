import java.util.Scanner;

public class TicTacToe {
    private final static int BOARD_SIZE = 3;
    private final static String LINE = "-------";
    private final static char DIV = '|';
    private final static char FREE_SPACE = ' ';
    private final static char X = 'X';
    private final static char O = 'O';
    private final static String HELP1 = "help";
    private final static String HELP2 = "h";
    /* The board:
        -------
        |1|2|3|
        -------
        |4|5|6|
        -------
        |7|8|9|
        -------
    */
    private char[][] board = new char[BOARD_SIZE][BOARD_SIZE]; // [row][col]
    private boolean player1Turn = true; // keep track of player 1 vs 2 turn

    public TicTacToe() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int k = 0; k < BOARD_SIZE; k++) {
                board[i][k] = FREE_SPACE;
            }
        }
    }

    // playerOne param true if for player 1 turn, 2 for player 2
    private void takeTurn(boolean playerOne) {
        String name = (playerOne) ? "Player 1" : "Player 2";
        char marker = (playerOne) ? X : O;
        System.out.println("Enter a board position. Enter help or h for guide.");
        boolean valid = false;
        while (!valid) {
            String[] input = getUserInput().split("\\s+");
            if (input.length > 1) {
                System.out.println("Too many commands! Please enter only a board position or help command.");
            } else {
                if (input[0].equalsIgnoreCase(HELP1) || input[0].equalsIgnoreCase(HELP2)) {
                    printGuide();
                    System.out.println("Enter a board position.");
                } else {
                    try {
                        int choice = Integer.parseInt(input[0]);
                        if (choice >= 1 && choice <= 9) {
                            valid = true;
                        } else {
                            System.out.println("Invalid board entry. Number must be between 1 and 9.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid command! Enter a board position or a help command.");
                    }
                }
            }
        }
    }

    // returns true if given choice is not empty.
    private boolean spaceAvailable(int choice) {
        boolean result = false;
        switch (choice) {
            case 1:
                result = (board[0][0] == FREE_SPACE);
                break;
            case 2:
                result = (board[0][0] == FREE_SPACE);
                break;
            case 3:
                result = (board[0][0] == FREE_SPACE);
                break;
            case 4:
                result = (board[0][0] == FREE_SPACE);
                break;
            case 5:
                result = (board[0][0] == FREE_SPACE);
                break;
            case 6:
                result = (board[0][0] == FREE_SPACE);
                break;
            case 7:
                result = (board[0][0] == FREE_SPACE);
                break;
            case 8:
                result = (board[0][0] == FREE_SPACE);
                break;
            case 9:
                result = (board[0][0] == FREE_SPACE);
                break;
        }
        return result;
    }

    // Asks user to input a number until a valid board number (between 1 and 9) is entered.
    private int getBoardInt() {
        int choice = getUserInt();
        while (choice < 1 || choice > 9) {
            System.out.println("Not a valid board position! Try again.");
            choice = getUserInt();
        }
        return choice;
    }

    private int getUserInt() {
        int result = 0;
        boolean valid = false;
        while (!valid) {
            try {
                result = Integer.parseInt(getUserInput());
                valid = true;
            } catch (Exception e) {
                System.out.println("Not an integer! Try again.");
            }
        }
        return result;
    }

    private String getUserInput() {
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

    private void printBoard() {
        System.out.println(LINE);
        System.out.println(DIV + board[0][0] + DIV + board[0][1] + DIV + board[0][2] + DIV);
        System.out.println(LINE);
        System.out.println(DIV + board[1][0] + DIV + board[1][1] + DIV + board[1][2] + DIV);
        System.out.println(LINE);
        System.out.println(DIV + board[2][0] + DIV + board[2][1] + DIV + board[2][2] + DIV);
        System.out.println(LINE + "\n");
    }

    private void printGuide() {
        System.out.println(LINE);
        System.out.println(DIV + 1 + DIV + 2 + DIV + 3 + DIV);
        System.out.println(LINE);
        System.out.println(DIV + 4 + DIV + 5 + DIV + 6 + DIV);
        System.out.println(LINE);
        System.out.println(DIV + 7 + DIV + 8 + DIV + 9 + DIV);
        System.out.println(LINE + "\n");
    }

    private void greet() {
        System.out.println("Welcome to Tic Tac Toe!");
    }
}
