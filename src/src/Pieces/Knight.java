package Pieces;

/**
 * The Knight class represents a knight chess piece.
 * It extends the ChessPiece class and implements the specific movement rules for knights.
 */
public class Knight extends ChessPiece {

    /**
     * Constructs a Knight with the specified color.
     *
     * @param isWhite true if the knight is white, false if the knight is black
     */
    public Knight(boolean isWhite) {
        super(isWhite ? 'N' : 'n', isWhite);
    }

    /**
     * Determines if a move is valid for this knight.
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
        if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
            return board[toRow][toCol] == null || board[toRow][toCol].isWhite() != isWhite;
        }
        return false;
    }
}