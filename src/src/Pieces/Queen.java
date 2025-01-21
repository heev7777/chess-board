package Pieces;

/**
 * The Queen class represents a queen chess piece.
 * It extends the ChessPiece class and implements the specific movement rules for queens.
 */
public class Queen extends ChessPiece {

    /**
     * Constructs a Queen with the specified color.
     *
     * @param isWhite true if the queen is white, false if the queen is black
     */
    public Queen(boolean isWhite) {
        super(isWhite ? 'Q' : 'q', isWhite);
    }

    /**
     * Determines if a move is valid for this queen.
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
        if (fromRow == toRow || fromCol == toCol) {
            int rowStep = Integer.compare(toRow, fromRow);
            int colStep = Integer.compare(toCol, fromCol);
            for (int i = fromRow + rowStep, j = fromCol + colStep; i != toRow || j != toCol; i += rowStep, j += colStep) {
                if (board[i][j] != null) {
                    return false;
                }
            }
            return board[toRow][toCol] == null || board[toRow][toCol].isWhite() != isWhite;
        } else if (Math.abs(fromRow - toRow) == Math.abs(fromCol - toCol)) {
            int rowStep = Integer.compare(toRow, fromRow);
            int colStep = Integer.compare(toCol, fromCol);
            for (int i = fromRow + rowStep, j = fromCol + colStep; i != toRow || j != toCol; i += rowStep, j += colStep) {
                if (board[i][j] != null) {
                    return false;
                }
            }
            return board[toRow][toCol] == null || board[toRow][toCol].isWhite() != isWhite;
        }
        return false;
    }
}