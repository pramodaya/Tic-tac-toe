package com.study.home.demo2;

public class Controller {

    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void handleButtonClick(int row, int col) {
        // Player makes a move
        model.makeMove(row, col);

        // Computer's turn (if it's the computer's turn)
        if (!model.isGameOver() && model.getCurrentPlayer() == 'O') {
            model.computerMove();
        }

        // Update all buttons after all moves (including computer's)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                view.updateButton(i, j, model.getBoard()[i][j]);
            }
        }

        // Check for game over and display the result
        if (model.isGameOver()) {
            view.showGameOverMessage(model.getWinner());
            view.disableAllButtons();
        } else {
            view.enableAllButtons();
        }
    }

    public Model getModel() {
        return model;
    }
}
