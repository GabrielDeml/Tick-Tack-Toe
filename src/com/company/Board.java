package com.company;

public class Board {
    private posState[][] board;
    private int width, height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        board = new posState[width][height];
        fillBoard(board);
    }

    /**
     * Fills a board with _
     *
     * @param board Character[][]
     */
    private void fillBoard(posState[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = posState.EMPTY;
            }
        }
    }

    /**
     * Pretty print board
     */
    public void printBoard() {
        for (posState[] row : this.board) {
            for (posState pos : row) {
                System.out.print(valPosState(pos) + "  ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Get pretty value of posState
     *
     * @return string of posState
     */
    public String valPosState(posState posState) {
        switch (posState) {
            case EMPTY:
                return "_";
            case PLAYER_O:
                return "O";
            case PLAYER_X:
                return "X";
        }
        return null;
    }

    /**
     * Get the state of a position
     *
     * @param row Row on the board
     * @param column Column on the board
     * @return posState
     */
    public posState getStateOfPos(int row, int column) {
        if(row < this.width && column < this.height){
            return this.board[row][column];
        }
        return posState.DOES_NOT_EXIST;
    }

    /**
     * Set the state of a position
     *
     * @param row Row on the board
     * @param column Column on the board
     * @param posstate New state
     */
    public void setStateOfPos(int row, int column, posState posstate) {
        this.board[row][column] = posstate;
    }

    /**
     * Get row length
     *
     * @return row length
     */
    public int getRowLength() {
        return this.board[0].length;
    }

    /**
     * Get row column
     *
     * @return row length
     */
    public int getColumnLength() {
        return this.board.length;
    }

    public enum posState {
        EMPTY,
        PLAYER_X,
        PLAYER_O,
        DOES_NOT_EXIST
    }
}
