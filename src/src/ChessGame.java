import java.util.Scanner;

/**
 * The ChessGame class represents a chess game that can be played by two players.
 * It manages the game state, handles player input, and controls the flow of the game.
 */
public class ChessGame {
    private ChessBoard chessBoard;
    private static int gamesPlayed = 0;
    private int moveCount = 0;
    private boolean whiteTurn = true;

    /**
     * Constructs a new ChessGame and initializes the chess board.
     * Increments the count of games played.
     */
    public ChessGame() {
        chessBoard = new ChessBoard();
        gamesPlayed++;
    }

    /**
     * Starts the chess game, providing a menu for the user to print the board, play the game, or exit.
     */
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Print Board");
            System.out.println("2. Play Game");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    chessBoard.printBoard();
                    break;
                case 2:
                    playGame(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    /**
     * Handles the main gameplay loop, alternating turns between white and black players.
     * @param scanner the Scanner object for reading player input
     */
    private void playGame(Scanner scanner) {
        while (!chessBoard.isGameOver()) {
            chessBoard.printBoard();
            System.out.println((whiteTurn ? "White" : "Black") + "'s turn");
            System.out.print("Enter move (e.g., e2 e4) or type 'withdraw' to end the game: ");
            String from = scanner.next();
            if (from.equalsIgnoreCase("withdraw")) {
                System.out.println((whiteTurn ? "White" : "Black") + " has withdrawn. Game over.");
                return;
            }
            String to = scanner.next();
            if (isValidInput(from, to) && chessBoard.movePiece(from, to)) {
                moveCount++;
                whiteTurn = !whiteTurn;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        System.out.println("Game over in " + moveCount + " moves.");
    }

    /**
     * Validates the input for a move, ensuring it is in the correct format.
     * @param from the starting position in algebraic notation (e.g., "e2")
     * @param to the ending position in algebraic notation (e.g., "e4")
     * @return true if the input is valid, false otherwise
     */
    private boolean isValidInput(String from, String to) {
        return from.length() == 2 && to.length() == 2 &&
                from.charAt(0) >= 'a' && from.charAt(0) <= 'h' &&
                from.charAt(1) >= '1' && from.charAt(1) <= '8' &&
                to.charAt(0) >= 'a' && to.charAt(0) <= 'h' &&
                to.charAt(1) >= '1' && to.charAt(1) <= '8';
    }

    /**
     * The main method to start the chess game.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.startGame();
    }
}