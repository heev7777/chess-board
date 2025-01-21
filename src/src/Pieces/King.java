package Pieces;

/**
 * The King class represents a king chess piece.
 * It extends the ChessPiece class and implements the specific movement rules for kings.
 */
public class King extends ChessPiece {

    /**
     * Constructs a King with the specified color.
     *
     * @param isWhite true if the king is white, false if the king is black
     */
    public King(boolean isWhite) {
        super(isWhite ? 'K' : 'k', isWhite);
    }

    /**
     * Determines if a move is valid for this king.
     *
     * @param fromRow the starting row of the move
     * @param fromCol the starting column of the move
     * @param toRow the ending row of the move
     * @param toCol the ending column of the move
     * @param board the current state of the chess board
     * @return true if the move is valid, false otherwise
     */
    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board) {
        int rowDiff = Math.abs(fromRow - toRow);
        int colDiff = Math.abs(fromCol - toCol);
        if (rowDiff <= 1 && colDiff <= 1) {
            return board[toRow][toCol] == null || board[toRow][toCol].isWhite() != isWhite;
        }
        return false;
    }
}