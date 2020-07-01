package com.company;

import static java.lang.System.exit;

public class Main {
    private final static int width = 3, height = 3;

    public static void main(String[] args) {
        // Init the classes
        Board board = new Board(width, height);
        Game game = new Game();
        // Init the move of the player
        int[] playerMove;
        // Init who's turn it is
        Board.posState playerTurn = Board.posState.PLAYER_O;
        // For the number of spots on the board
        for (int moveCount = 0; moveCount < width * height; moveCount++) {
            // Print the board
            board.printBoard();
            // Tell the user who's turn it is
            System.out.println("It is " + board.valPosState(playerTurn) + "'s turn");
            // Get the users move
            playerMove = game.getUserInput();
            // Check if it is a valid move
            if (board.getStateOfPos(playerMove[0], playerMove[1]) != Board.posState.EMPTY ||
                    board.getStateOfPos(playerMove[0], playerMove[1]) == Board.posState.DOES_NOT_EXIST) {
                moveCount--;
                System.out.println("Please enter a valid move");
                continue;
            }
            // Write the players move to the board
            board.setStateOfPos(playerMove[0], playerMove[1], playerTurn);
            // Switch who's turn it is
            playerTurn = playerTurn == Board.posState.PLAYER_O ? Board.posState.PLAYER_X : Board.posState.PLAYER_O;
            // Check if anyone has won the game
            Board.posState hasPlayerWon = game.hasPlayerWon(board);
            // If they have won
            if (hasPlayerWon != null) {
                // Print the board
                board.printBoard();
                // Print who has won
                System.out.println("Player " + hasPlayerWon + " won!!!");
                // Exit the game
                exit(0);
            }
        }
        // If we get to this state no one must have won
        System.out.println("No one won");
    }
}
