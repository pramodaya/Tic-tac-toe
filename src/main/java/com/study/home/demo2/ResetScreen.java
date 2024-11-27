package com.study.home.demo2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ResetScreen extends Stage {

    public ResetScreen(View view, Model model) {
        this.setTitle("Reset Game");

        // Create a button for resetting the game
        Button resetButton = new Button("Reset Game");
        resetButton.setOnAction(event -> {
            // Reset the model (game board)
            model.initializeBoard();
            model.currentPlayer = 'X'; // Start with player X

            // Update the view with the reset model
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    view.updateButton(i, j, model.getBoard()[i][j]);
                }
            }
            view.getResultLabel().setText(""); // Clear result message
            view.enableAllButtons();

            // Close this reset screen
            close();
        });

        // Create a button to clear the scores and restart the game
        Button clearScoreButton = new Button("Clear Scores & Restart");
        clearScoreButton.setOnAction(event -> {
            // Clear the scores in the model
            model.resetScores();

            // Reset the game board
            model.initializeBoard();
            model.currentPlayer = 'X'; // Start with player X

            // Update the view with the reset model
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    view.updateButton(i, j, model.getBoard()[i][j]);
                }
            }

            // Clear the result message and update the score label
            view.getResultLabel().setText("");
            view.updateScoreLabel();

            // Enable all buttons to start the new game
            view.enableAllButtons();

            // Close this reset screen
            close();
        });

        // Center the buttons on the screen
        HBox hbox = new HBox(10);  // Add some space between the buttons
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(resetButton, clearScoreButton);

        // Create the scene for this stage
        Scene scene = new Scene(hbox);

        // Set the scene and show the stage
        setScene(scene);
    }
}
