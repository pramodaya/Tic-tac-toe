package com.study.home.demo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    private Model model;

    @BeforeEach
    void setUp() {
        model = new Model();
    }

    @Test
    void testInitializeBoard() {
        model.initializeBoard();
        char[][] board = model.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', board[i][j], "Board should be initialized with '-'");
            }
        }
    }

    @Test
    void testMakeMove() {
        model.initializeBoard();
        model.makeMove(0, 0);
        assertEquals('X', model.getBoard()[0][0], "Player X should have made a move at (0, 0)");

        model.makeMove(1, 1);
        assertEquals('O', model.getBoard()[1][1], "Player O should have made a move at (1, 1)");
    }

    @Test
    void testGameOverWithWinner() {
        model.initializeBoard();
        model.makeMove(0, 0); // X
        model.makeMove(1, 0); // O
        model.makeMove(0, 1); // X
        model.makeMove(1, 1); // O
        model.makeMove(0, 2); // X - X wins

        assertTrue(model.isGameOver(), "Game should be over after X wins");
        assertEquals('X', model.getWinner(), "Player X should be the winner");
    }

    @Test
    void testGameOverWithDraw() {
        model.initializeBoard();
        model.makeMove(0, 0); // X
        model.makeMove(1, 0); // O
        model.makeMove(0, 1); // X
        model.makeMove(1, 1); // O
        model.makeMove(0, 2); // X
        model.makeMove(1, 2); // O
        model.makeMove(2, 0); // X
        model.makeMove(2, 1); // O
        model.makeMove(2, 2); // X - Draw

        assertTrue(model.isGameOver(), "Game should be over with a draw");
        assertEquals('-', model.getWinner(), "There should be no winner (draw)");
    }

    @Test
    void testResetScores() {
        model.initializeBoard();
        model.makeMove(0, 0); // X
        model.makeMove(1, 0); // O
        model.makeMove(0, 1); // X
        model.makeMove(1, 1); // O
        model.makeMove(0, 2); // X wins

        model.resetScores();
        assertEquals(0, model.getScoreX(), "Player X score should be reset to 0");
        assertEquals(0, model.getScoreO(), "Player O score should be reset to 0");
    }
}
