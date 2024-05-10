package com.example.todoapp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import static javafx.application.Application.launch;





public class TodoListApp extends Application {

    TodoList todoList =  TodoList.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        // Call the fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(TodoListApp.class.getResource("Home.fxml"));
        // Create a view of fxml file with dimension 2000,2000
        Scene scene = new Scene(fxmlLoader.load(), 785, 500);
        VBox todoListDisplay = (VBox) scene.lookup("#todoListDisplay");
        // Add brief view of tasks to the VBOX
        addTasksToView(todoListDisplay, todoList);

        // Set the title of the todo list
        stage.setTitle("New Todo List");
        // set the Scene
        stage.setScene(scene);
        // Show the updated contents of the file
        stage.show();



    }

    public static void addTasksToView(VBox todoListDisplay, TodoList todoList) throws IOException {

        for (int idx = 0; idx < todoList.getLength(); idx++) {

            FXMLLoader fxmlLoader = new FXMLLoader(TodoListApp.class.getResource("Display.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 50, 20);
            AnchorPane anchorPane = (AnchorPane) scene.lookup("#DisplayAnchor");
            TodoItem task = todoList.getItem(idx);
            Text titleText = (Text) anchorPane.lookup("#DisplayTitle");
            titleText.setText(task.getTitle());

            Text priorityText = (Text) anchorPane.lookup("#DisplayPriority");
            if (task.getPriority()) {
                priorityText.setText("Yes");
            }
            else priorityText.setText("No");

            Text dateText = (Text) anchorPane.lookup("#DisplayDate");
            Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateText.setText(format.format(task.getDueDate()));

            Text textID = (Text) anchorPane.lookup("#textID");
            textID.setText(String.valueOf(idx));
            textID.setVisible(false);

            todoListDisplay.getChildren().add(anchorPane);
            anchorPane.setStyle("-fx-background-color: orange;");
        }
    }
}

