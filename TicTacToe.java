import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3]; // 3x3 grid
    private static char currentPlayer = 'X'; // Player X starts

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            initializeBoard();
            playGame(scanner);
            playAgain = askToPlayAgain(scanner);
        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    // Initialize or reset the board
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-'; // Empty cells represented by '-'
            }
        }
    }

    // Main game loop
    private static void playGame(Scanner scanner) {
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            playerMove(scanner);
            gameEnded = checkWin() || checkDraw();

            // Switch players after each move
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    // Print the current board state
    private static void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Get the player's move
    private static void playerMove(Scanner scanner) {
        int row = -1, col = -1;

        while (true) {
            System.out.println("Player " + currentPlayer + "'s turn. Enter your move (row and column, 1-3):");
            System.out.print("Row (1-3): ");
            row = scanner.nextInt() - 1;
            System.out.print("Column (1-3): ");
            col = scanner.nextInt() - 1;

            // Validate input
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("This move is invalid. Try again.");
            }
        }
    }

    // Check for a win
    private static boolean checkWin() {
        // Check rows, columns, and diagonals
        if (checkRows() || checkColumns() || checkDiagonals()) {
            printBoard();
            System.out.println("Player " + currentPlayer + " wins!");
            return true;
        }
        return false;
    }

    // Check if the game is a draw
    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false; // There's still an empty cell
                }
            }
        }
        printBoard();
        System.out.println("The game is a draw!");
        return true;
    }

    // Check if any row has the same symbol
    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    // Check if any column has the same symbol
    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    // Check if any diagonal has the same symbol
    private static boolean checkDiagonals() {
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }
        return false;
    }

    // Ask if players want to play again
    private static boolean askToPlayAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (y/n): ");
        char response = scanner.next().toLowerCase().charAt(0);
        return response == 'y';
    }
}
