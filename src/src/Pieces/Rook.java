package Pieces;

/**
 * The Rook class represents a rook chess piece.
 * It extends the ChessPiece class and implements the specific movement rules for rooks.
 */
public class Rook extends ChessPiece {

    /**
     * Constructs a Rook with the specified color.
     *
     * @param isWhite true if the rook is white, false if the rook is black
     */
    public Rook(boolean isWhite) {
        super(isWhite ? 'R' : 'r', isWhite);
    }

    /**
     * Determines if a move is valid for this rook.
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
        if (fromRow != toRow && fromCol != toCol) {
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