import java.util.Scanner;

public class TicTacToe {
    private final static int BOARD_SIZE = 3;
    private final static String LINE = "-------";
    private final static String DIV = "|";
    private final static char FREE_SPACE = ' ';
    private final static char MARKER_P1 = 'X';
    private final static char MARKER_P2 = 'O';
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
    private char[][] board = new char[BOARD_SIZE][BOARD_SIZE]; // [row][col], from top left to bottom right

    public TicTacToe() {
        reset();
    }

    // playerOne param true if for player 1 turn, 2 for player 2
    public void takeTurn(boolean playerOne) {
        if (boardFull()) {
            System.out.println("Board full. Turn cannot be taken.");
            return;
        }

        printBoard();
        String name = (playerOne) ? "Player 1" : "Player 2";
        System.out.println(name + ", enter a board position. Enter help or h for guide.");
        boolean valid = false;
        while (!valid) {
            valid = true;
            String[] input = getUserInput().split("\\s+");

            // check for too much input
            if (input.length > 1) {
                System.out.println("Too many commands! Please enter only a board position or help command.");
                valid = false;
            }

            // check for help command
            if (valid && (input[0].equalsIgnoreCase(HELP1) || input[0].equalsIgnoreCase(HELP2))) {
                printGuide();
                System.out.println("Enter a board position.");
                valid = false;
            }

            // check for valid board number
            int choice = 0;
            if (valid) {
                try {
                    choice = Integer.parseInt(input[0]);
                    if (choice < 1 || choice > 9) {
                        System.out.println("Invalid board entry. Number must be between 1 and 9.");
                        valid = false;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid command! Enter a board position or a help command.");
                    valid = false;
                }
            }

            // check for space availability, and make move
            if (valid) {
                if (!spaceAvailable(choice)) {
                    System.out.println("Space not available. Try again.");
                    valid = false;
                } else {
                    char marker = (playerOne) ? MARKER_P1 : MARKER_P2;
                    setBoardPosition(choice, marker);
                    System.out.println(name + " chose board position " + choice + ".");
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
                result = (board[0][1] == FREE_SPACE);
                break;
            case 3:
                result = (board[0][2] == FREE_SPACE);
                break;
            case 4:
                result = (board[1][0] == FREE_SPACE);
                break;
            case 5:
                result = (board[1][1] == FREE_SPACE);
                break;
            case 6:
                result = (board[1][2] == FREE_SPACE);
                break;
            case 7:
                result = (board[2][0] == FREE_SPACE);
                break;
            case 8:
                result = (board[2][1] == FREE_SPACE);
                break;
            case 9:
                result = (board[2][2] == FREE_SPACE);
                break;
        }
        return result;
    }

    private void setBoardPosition(int position, char marker) {
        switch (position) {
            case 1:
                board[0][0] = marker;
                break;
            case 2:
                board[0][1] = marker;
                break;
            case 3:
                board[0][2] = marker;
                break;
            case 4:
                board[1][0] = marker;
                break;
            case 5:
                board[1][1] = marker;
                break;
            case 6:
                board[1][2] = marker;
                break;
            case 7:
                board[2][0] = marker;
                break;
            case 8:
                board[2][1] = marker;
                break;
            case 9:
                board[2][2] = marker;
                break;
        }
    }

    private String getUserInput() {
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

    public void printBoard() {
        System.out.println(LINE);
        System.out.println(DIV + board[0][0] + DIV + board[0][1] + DIV + board[0][2] + DIV);
        System.out.println(LINE);
        System.out.println(DIV + board[1][0] + DIV + board[1][1] + DIV + board[1][2] + DIV);
        System.out.println(LINE);
        System.out.println(DIV + board[2][0] + DIV + board[2][1] + DIV + board[2][2] + DIV);
        System.out.println(LINE + "\n");
    }

    private void printGuide() {
        System.out.println("Position guide:");
        System.out.println(LINE);
        System.out.println(DIV + 1 + DIV + 2 + DIV + 3 + DIV);
        System.out.println(LINE);
        System.out.println(DIV + 4 + DIV + 5 + DIV + 6 + DIV);
        System.out.println(LINE);
        System.out.println(DIV + 7 + DIV + 8 + DIV + 9 + DIV);
        System.out.println(LINE + "\n");
    }

    public boolean checkVictory(boolean player1) {
        boolean win = false;
        char marker = (player1) ? MARKER_P1 : MARKER_P2;

        // checks are hard coded for simplicity/speed of development
        // rows
        if (board[0][0] == marker && board[0][1] == marker && board[0][2] == marker) win = true;
        if (board[1][0] == marker && board[1][1] == marker && board[1][2] == marker) win = true;
        if (board[2][0] == marker && board[2][1] == marker && board[2][2] == marker) win = true;
        // columns
        if (board[0][0] == marker && board[1][0] == marker && board[2][0] == marker) win = true;
        if (board[0][1] == marker && board[1][1] == marker && board[2][1] == marker) win = true;
        if (board[0][2] == marker && board[1][2] == marker && board[2][2] == marker) win = true;
        // diagonals
        if (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) win = true;
        if (board[2][0] == marker && board[1][1] == marker && board[0][2] == marker) win = true;

        return win;
    }

    public boolean boardFull() {
        boolean result = true;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int k = 0; k < BOARD_SIZE; k++) {
                if (board[i][k] == FREE_SPACE) {
                    result = false;
                    i = BOARD_SIZE;
                    k = BOARD_SIZE;
                }
            }
        }
        return result;
    }

    public void reset() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int k = 0; k < BOARD_SIZE; k++) {
                board[i][k] = FREE_SPACE;
            }
        }
    }
}
