package com.tdd.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TicTacToeTest {

    private TicTacToe board;

    @BeforeEach
    public void setup() {
        board = new TicTacToe();
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,0", "3,1", "4,2"}, delimiter = ',')
    public void whenXOutsideBoardThenInvalidPositionException(int x, int y) {
        Assertions.assertThrows(InvalidPositionException.class, () ->
                board.play(x, y)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"0,-1", "1,3", "2,4"}, delimiter = ',')
    public void whenYOutsideBoardThenInvalidPositionException(int x, int y) {
        Assertions.assertThrows(InvalidPositionException.class, () ->
                board.play(x, y)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "0,1", "0,2",
            "1,0", "1,1", "1,2",
            "2,0", "2,1", "2,2",
    }, delimiter = ',')
    public void whenBoxIsOccupiedThenInvalidPositionException(int occupiedX, int occupiedY) {
        board.play(occupiedX, occupiedY);
        Assertions.assertThrows(InvalidPositionException.class, () ->
                board.play(occupiedX, occupiedY)
        );
    }
}
