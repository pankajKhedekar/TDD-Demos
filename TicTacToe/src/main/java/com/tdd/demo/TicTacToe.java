package com.tdd.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TicTacToe {
    Character[][] board = new Character[9][9];

    public void play(int x, int y) {
        validateAxis(x);
        validateAxis(y);
        setBox(x, y);
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
}
