import Pieces.*;

/**
 * The ChessBoard class represents an 8x8 chess board and manages the state of the game.
 * It initializes the board with pieces, handles piece movements, and checks for game-over conditions.
 */
public class ChessBoard {
    public static final int BOARD_SIZE = 8;
    private ChessPiece[][] board;

    /**
     * Constructs a new ChessBoard and initializes it with the standard chess setup.
     */
    public ChessBoard() {
        board = new ChessPiece[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    /**
     * Initializes the chess board with pieces in their standard starting positions.
     */
    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = null;
            }
        }
        for (int j = 0; j < BOARD_SIZE; j++) {
            board[1][j] = new Pawn(false); // Black pawns
            board[6][j] = new Pawn(true);  // White pawns
        }
        board[0][0] = board[0][7] = new Rook(false);
        board[7][0] = board[7][7] = new Rook(true);
        board[0][1] = board[0][6] = new Knight(false);
        board[7][1] = board[7][6] = new Knight(true);
        board[0][2] = board[0][5] = new Bishop(false);
        board[7][2] = board[7][5] = new Bishop(true);
        board[0][3] = new Queen(false);
        board[7][3] = new Queen(true);
        board[0][4] = new King(false);
        board[7][4] = new King(true);
    }

    /**
     * Prints the current state of the chess board to the console.
     */
    public void printBoard() {
        System.out.print("  ");
        for (int j = 0; j < BOARD_SIZE; j++) {
            System.out.print((char)('a' + j) + " ");
        }
        System.out.println();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((BOARD_SIZE - i) + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print((board[i][j] == null ? '.' : board[i][j].getSymbol()) + " ");
            }
            System.out.println();
        }
    }

    /**
     * Moves a piece from one position to another if the move is valid.
     *
     * @param from the starting position in algebraic notation (e.g., "e2")
     * @param to the ending position in algebraic notation (e.g., "e4")
     * @return true if the move is valid and executed, false otherwise
     */
    public boolean movePiece(String from, String to) {
        int fromRow = BOARD_SIZE - (from.charAt(1) - '0');
        int fromCol = from.charAt(0) - 'a';
        int toRow = BOARD_SIZE - (to.charAt(1) - '0');
        int toCol = to.charAt(0) - 'a';

        ChessPiece piece = board[fromRow][fromCol];
        if (piece != null && piece.isValidMove(fromRow, fromCol, toRow, toCol, board)) {
            board[toRow][toCol] = piece;
            board[fromRow][fromCol] = null;
            return true;
        }
        return false;
    }

    /**
     * Checks if the game is over by verifying if either king is no longer on the board.
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        boolean whiteKing = false;
        boolean blackKing = false;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].getSymbol() == 'K') whiteKing = true;
                    if (board[i][j].getSymbol() == 'k') blackKing = true;
                }
            }
        }
        return !(whiteKing && blackKing);
    }
}