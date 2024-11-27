package com.study.home.demo2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) {
        // Create the View (Game UI)
        View view = new View();

        // Create the Scene from the View's layout
        Scene scene = view.createLayout();

        // Set up the Stage (window)
        stage.setTitle("Tic-Tac-Toe");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
