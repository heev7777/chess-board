package Pieces;

/**
 * The Pawn class represents a pawn chess piece.
 * It extends the ChessPiece class and implements the specific movement rules for pawns.
 */
public class Pawn extends ChessPiece {

    /**
     * Constructs a Pawn with the specified color.
     *
     * @param isWhite true if the pawn is white, false if the pawn is black
     */
    public Pawn(boolean isWhite) {
        super(isWhite ? 'P' : 'p', isWhite);
    }

    /**
     * Determines if a move is valid for this pawn.
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
        int direction = isWhite ? -1 : 1;
        if (fromCol == toCol && board[toRow][toCol] == null) {
            if (toRow == fromRow + direction) {
                return true;
            }
            if ((isWhite && fromRow == 6 || !isWhite && fromRow == 1) && toRow == fromRow + 2 * direction) {
                return board[fromRow + direction][fromCol] == null;
            }
        }
        if (Math.abs(fromCol - toCol) == 1 && toRow == fromRow + direction && board[toRow][toCol] != null) {
            return board[toRow][toCol].isWhite() != isWhite;
        }
        return false;
    }
}