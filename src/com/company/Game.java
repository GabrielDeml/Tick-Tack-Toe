package com.company;

import java.util.Scanner;

public class Game {

    /**
     * Gets row and column from user
     *
     * @return Array holding row and column
     */
    public int[] getUserInput() {
        int[] returnArray = new int[2];
        System.out.print("Please enter row: ");
        Scanner Scanner = new Scanner(System.in);
        returnArray[0] = Scanner.nextInt();
        System.out.print("Please enter column: ");
        returnArray[1] = Scanner.nextInt();
        return returnArray;
    }

    /**
     * Decide if a player has won
     *
     * @param board
     * @return null if no one won and posState.PLAYER<X, 0> if won
     */
    public Board.posState hasPlayerWon(Board board) {
        for (int row = 0; row < board.getRowLength(); row++) {
            for (int col = 0; col < board.getColumnLength(); col++) {
                if (board.getStateOfPos(row, col) != Board.posState.EMPTY &&
                        (isPositionWinningColumn(board, row, col) ||
                                isPositionWinningRow(board, row, col) ||
                                isPositionWinningDiagonal(board, row, col))) {
                    return board.getStateOfPos(row, col);
                }
            }
        }
        return null;
    }

    /**
     * Check the column of pos for winning player
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isPositionWinningColumn(Board board, int row, int col) {
        Board.posState player = board.getStateOfPos(row, col);
        // Check Column
        for (int pos = 0; pos < board.getColumnLength(); pos++) {
            if (player != board.getStateOfPos(pos, col)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check the row of pos for winning player
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isPositionWinningRow(Board board, int row, int col) {
        Board.posState player = board.getStateOfPos(row, col);
        for (int pos = 0; pos < board.getRowLength(); pos++) {
            if (player != board.getStateOfPos(row, pos)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check the diagonal of pos for winning player
     *
     * @param board
     * @param row
     * @param col
     * @return bool of win or loss
     */
    private boolean isPositionWinningDiagonal(Board board, int row, int col) {
        if (board.getRowLength() != board.getColumnLength()) {
            return false;
        }
        return checkDiagonalTopRightToBottomLeft(board, row, col) || checkDiagonalTopLeftToBottomRight(board, row, col);
    }

    /**
     * Check the TopLeftToBottomRight of pos for winning player
     *
     * @param board
     * @param row
     * @param col
     * @return bool of win or loss
     */
    private boolean checkDiagonalTopLeftToBottomRight(Board board, int row, int col) {
        Board.posState player = board.getStateOfPos(row, col);
        if (player == Board.posState.EMPTY || player == Board.posState.DOES_NOT_EXIST) {
            return false;
        }
        for (int pos = 0; pos < board.getRowLength(); pos++) {
            if (player != board.getStateOfPos(pos, pos)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check the TopRightToBottomLeft of pos for winning player
     *
     * @param board
     * @param row
     * @param col
     * @return bool of win or loss
     */
    private boolean checkDiagonalTopRightToBottomLeft(Board board, int row, int col) {
        Board.posState player = board.getStateOfPos(row, col);
        if (player == Board.posState.EMPTY || player == Board.posState.DOES_NOT_EXIST) {
            return false;
        }
        for (int pos = 0; pos < board.getRowLength(); pos++) {
            if (player != board.getStateOfPos(pos, board.getColumnLength() - pos - 1)) {
                return false;
            }
        }
        return true;
    }
}
