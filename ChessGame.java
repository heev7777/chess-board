import java.util.Scanner;

public class ChessGame {
    private ChessBoard chessBoard;
    private static int gamesPlayed = 0;
    private int moveCount = 0;
    private boolean whiteTurn = true;

    public ChessGame() {
        chessBoard = new ChessBoard();
        gamesPlayed++;
    }

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

    private boolean isValidInput(String from, String to) {
        return from.length() == 2 && to.length() == 2 &&
                from.charAt(0) >= 'a' && from.charAt(0) <= 'h' &&
                from.charAt(1) >= '1' && from.charAt(1) <= '8' &&
                to.charAt(0) >= 'a' && to.charAt(0) <= 'h' &&
                to.charAt(1) >= '1' && to.charAt(1) <= '8';
    }

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.startGame();
    }
}