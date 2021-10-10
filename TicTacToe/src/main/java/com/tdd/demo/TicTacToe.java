package com.tdd.demo;

public class TicTacToe {
    private final Character[][] board = new Character[9][9];
    private char lastPlayer = 0;

    public void play(int x, int y) {
        validateAxis(x);
        validateAxis(y);
        setBox(x, y);
        lastPlayer = getNextPlayer();
    }

    private void setBox(int x, int y) {
        if (board[x][y] != null) {
            throw new InvalidPositionException();
        } else {
            board[x][y] = 'X';
        }
    }

    private void validateAxis(int axis) {
        if (axis < 0 || axis > 2) {
            throw new InvalidPositionException();
        }
    }

    public char getNextPlayer() {
        if (lastPlayer == 'X')
            return 'O';
        else
            return 'X';
    }
}
