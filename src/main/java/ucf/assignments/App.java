package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ursula Shaw
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static ToDoListController AppController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ToDoList.fxml"));
            
            Scene scene = new Scene(root);

            AppController = new FXMLLoader(App.class.getResource("ToDoList.fxml")).getController();
            
            primaryStage.setScene(scene);
            primaryStage.setTitle("To-Do List");
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void stop() throws Exception {
        ItemSerializer.serialize(AppController.getItems());
        super.stop();
    }
}
