package Pieces;

/**
 * The ChessPiece class is an abstract base class for all chess pieces.
 * It defines common properties and methods that all chess pieces share.
 */
public abstract class ChessPiece {
    protected char symbol;
    protected boolean isWhite;

    /**
     * Constructs a ChessPiece with the specified symbol and color.
     *
     * @param symbol the character symbol representing the piece (e.g., 'P' for pawn)
     * @param isWhite true if the piece is white, false if the piece is black
     */
    public ChessPiece(char symbol, boolean isWhite) {
        this.symbol = symbol;
        this.isWhite = isWhite;
    }

    /**
     * Returns the symbol of the chess piece.
     *
     * @return the character symbol representing the piece
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Returns the color of the chess piece.
     *
     * @return true if the piece is white, false if the piece is black
     */
    public boolean isWhite() {
        return isWhite;
    }

    /**
     * Determines if a move is valid for this chess piece.
     *
     * @param fromRow the starting row of the move
     * @param fromCol the starting column of the move
     * @param toRow the ending row of the move
     * @param toCol the ending column of the move
     * @param board the current state of the chess board
     * @return true if the move is valid, false otherwise
     */
    public abstract boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, ChessPiece[][] board);
}