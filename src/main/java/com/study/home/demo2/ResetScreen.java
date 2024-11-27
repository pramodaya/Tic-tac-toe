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
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(event -> {
            // Reset the model
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


        // Center the button on the screen
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(resetButton);
        Scene scene = new Scene(hbox);

        setScene(scene);
    }
}
