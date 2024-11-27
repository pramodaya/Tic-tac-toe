package com.study.home.demo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ResetScreenTest {

    private Model model;
    private View view;
    private ResetScreen resetScreen;

    @BeforeEach
    void setUp() {
        model = new Model();
        view = mock(View.class); // Mock the View
        resetScreen = new ResetScreen(view, model);
    }

    @Test
    void testClearScoresAndRestart() {
        model.initializeBoard();
        model.makeMove(0, 0); // X
        model.makeMove(1, 0); // O
        model.makeMove(0, 1); // X
        model.makeMove(1, 1); // O
        model.makeMove(0, 2); // X wins

        model.resetScores();

        assertEquals(0, model.getScoreX(), "Player X score should be reset to 0 after clearing scores");
        assertEquals(0, model.getScoreO(), "Player O score should be reset to 0 after clearing scores");

        // Ensure the view is updated correctly
        verify(view).updateButton(0, 0, '-');
        verify(view).updateButton(0, 1, '-');
        verify(view).updateButton(0, 2, '-');
        // Add other grid cells and score label updates as needed
    }
}
