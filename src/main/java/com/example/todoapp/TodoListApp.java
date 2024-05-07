package com.example.todoapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;





public class TodoListApp extends Application {

    TodoList todoList =  TodoList.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        // Call the fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(TodoListApp.class.getResource("Home.fxml"));
        // Create a view of fxml file with dimension 2000,2000
        Scene scene = new Scene(fxmlLoader.load(), 590, 300);
        VBox todoListDisplay = (VBox) scene.lookup("#todoListDisplay");
        for (int idx = 0; idx < todoList.getLength(); idx++) {
            Label title = new Label(todoList.getItem(idx).getTitle());
            todoListDisplay.getChildren().add(title) ;
        }
        // Set the title of the todo list
        stage.setTitle("New Todo List");
        // set the Scene
        stage.setScene(scene);
        // Show the updated contents of the file
        stage.show();



    }
}

