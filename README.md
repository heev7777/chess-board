# Chess Game

This project is a simple implementation of a chess game in Java. It includes the core logic for the game, including piece movement, board setup, and game-over detection. The game can be played via a console interface.

## Features

- **Chess Pieces**: Implementation of all standard chess pieces (Pawn, Rook, Knight, Bishop, Queen, King) with their respective movement rules.
- **Chess Board**: An 8x8 board setup with initial positions for all pieces.
- **Game Logic**: Handling of piece movement, capturing, and game-over conditions.
- **Console Interface**: Simple text-based interface to play the game.

## Project Structure

- `src/src/ChessBoard.java`: Contains the ChessBoard class which manages the board and piece movements.
- `src/src/ChessGame.java`: Contains the ChessGame class which provides the console interface for playing the game.
- `src/src/Pieces/`: Directory containing classes for each chess piece (Pawn, Rook, Knight, Bishop, Queen, King).
- `test/src/ChessBoardTest.java`: Contains JUnit tests for the ChessBoard class to ensure correct piece movement and game-over detection.

## How to Run

1. Clone the repository:
    ```bash
    git clone <repository-url>
    cd <repository-directory>
    ```

2. Compile the project:
    ```bash
    javac src/src/*.java src/src/Pieces/*.java
    ```

3. Run the game:
    ```bash
    java src/src/ChessGame
    ```

## How to Test

1. Compile the tests:
    ```bash
    javac -cp .:path/to/junit-5.7.0.jar test/src/ChessBoardTest.java
    ```

2. Run the tests:
    ```bash
    java -cp .:path/to/junit-5.7.0.jar org.junit.runner.JUnitCore test/src/ChessBoardTest
    ```

## Example Usage

1. Start the game:
    ```bash
    java src/src/ChessGame
    ```

2. Follow the console prompts to print the board, make moves, or exit the game.