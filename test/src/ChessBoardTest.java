import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChessBoardTest {
    private ChessBoard chessBoard;

    @BeforeEach
    public void setUp() {
        chessBoard = new ChessBoard();
    }

    @Test
    public void testPawnMove() {
        assertTrue(chessBoard.movePiece("e2", "e4"));
        assertTrue(chessBoard.movePiece("e4", "e5")); // Valid move
    }

    @Test
    public void testRookMove() {
        chessBoard.movePiece("a2", "a4"); // Move pawn to free rook
        assertTrue(chessBoard.movePiece("a1", "a3"));
        assertFalse(chessBoard.movePiece("a3", "a5")); // Valid move, going to return false because of the pawn
    }

    @Test
    public void testKnightMove() {
        assertTrue(chessBoard.movePiece("b1", "c3"));
        assertTrue(chessBoard.movePiece("c3", "e4")); // Valid move
    }

    @Test
    public void testBishopMove() {
        chessBoard.movePiece("d2", "d4"); // Move pawn to free bishop
        assertTrue(chessBoard.movePiece("c1", "f4"));
        assertTrue(chessBoard.movePiece("f4", "e3")); // Valid move
        assertFalse(chessBoard.movePiece("e3", "h3")); // Invalid move, bishops can't move horizontally
    }

    @Test
    public void testQueenMove() {
        chessBoard.movePiece("d2", "d4"); // Move pawn to free queen
        assertTrue(chessBoard.movePiece("d1", "d3"));
        chessBoard.movePiece("d4", "d5");
        assertTrue(chessBoard.movePiece("d3", "f5")); // Valid move
    }

    @Test
    public void testKingMove() {
        chessBoard.movePiece("e2", "e4"); // Move pawn to free king
        assertTrue(chessBoard.movePiece("e1", "e2"));
        assertTrue(chessBoard.movePiece("e2", "e3")); // Valid move
    }

    @Test
    public void testGameOver() {
        chessBoard.movePiece("e2", "e4"); // Checkmate
        chessBoard.movePiece("e7", "e5");
        chessBoard.movePiece("d1", "h5");
        chessBoard.movePiece("f7", "f6");
        chessBoard.movePiece("h5", "e8");
        assertTrue(chessBoard.isGameOver());
    }
}