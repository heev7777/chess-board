package Pieces;

/**
 * The Bishop class represents a bishop chess piece.
 * It extends the ChessPiece class and implements the specific movement rules for bishops.
 */
public class Bishop extends ChessPiece {

    /**
     * Constructs a Bishop with the specified color.
     *
     * @param isWhite true if the bishop is white, false if the bishop is black
     */
    public Bishop(boolean isWhite) {
        super(isWhite ? 'B' : 'b', isWhite);
    }

    /**
     * Determines if a move is valid for this bishop.
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
        if (Math.abs(fromRow - toRow) != Math.abs(fromCol - toCol)) {
            return false;
        }
        int rowStep = Integer.compare(toRow, fromRow);
        int colStep = Integer.compare(toCol, fromCol);
        for (int i = fromRow + rowStep, j = fromCol + colStep; i != toRow || j != toCol; i += rowStep, j += colStep) {
            if (board[i][j] != null) {
                return false;
            }
        }
        return board[toRow][toCol] == null || board[toRow][toCol].isWhite() != isWhite;
    }
}