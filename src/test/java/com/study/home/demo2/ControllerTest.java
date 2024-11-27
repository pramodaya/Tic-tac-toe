package com.study.home.demo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private Model model;
    private View view;
    private Controller controller;

    @BeforeEach
    void setUp() {
        model = new Model();
        view = mock(View.class); // Mock View
        controller = new Controller(model, view);
    }

    @Test
    void testHandleButtonClickPlayerX() {
        model.initializeBoard();
        controller.handleButtonClick(0, 0);
        assertEquals('O', model.getCurrentPlayer(), "After X's move, it should be O's turn");
        verify(view).updateButton(0, 0, 'X'); // Ensure the view is updated
    }

    @Test
    void testHandleButtonClickGameOver() {
        model.initializeBoard();
        controller.handleButtonClick(0, 0); // X
        controller.handleButtonClick(1, 0); // O
        controller.handleButtonClick(0, 1); // X
        controller.handleButtonClick(1, 1); // O
        controller.handleButtonClick(0, 2); // X - X wins

        assertTrue(model.isGameOver(), "Game should be over after X wins");
        verify(view).showGameOverMessage('X'); // Ensure game over message is shown
    }
}
