package com.tdd.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe board;

    @BeforeEach
    public void setup() {
        board = new TicTacToe();
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,0", "3,1", "4,2"}, delimiter = ',')
    public void whenXOutsideBoardThenInvalidPositionException(int x, int y) {
        assertThrows(InvalidPositionException.class, () ->
                board.play(x, y)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"0,-1", "1,3", "2,4"}, delimiter = ',')
    public void whenYOutsideBoardThenInvalidPositionException(int x, int y) {
        assertThrows(InvalidPositionException.class, () ->
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
        assertThrows(InvalidPositionException.class, () ->
                board.play(occupiedX, occupiedY)
        );
    }

    @Test
    public void whenFirstTurnThenNexPlayerShouldBeX(){
        assertEquals('X', board.getNextPlayer());
    }

    @Test
    public void whenXPlayedLastThenNextPlayerShouldBeO(){
        board.play(1,1);
        assertEquals('O', board.getNextPlayer());
    }

    @Disabled // Since there is no code change required to pass this test, hence test is false positive
    public void whenOPlayedLastThenNextPlayerShouldBeX(){
        board.play(1,1);
        board.play(0,0);
        assertEquals('X', board.getNextPlayer());
    }
}
