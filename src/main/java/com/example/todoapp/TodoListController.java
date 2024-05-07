package com.example.todoapp;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Date;


public class TodoListController {
    @FXML
    private Button btnNewTask, btnCreateSave, btnCreateExit, btnEnter;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextField titleEnterTextfield;

    TodoList todoList =  TodoList.getInstance();

    @FXML
    protected void onCreateButtonClick () throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Task.fxml"));
        Stage window = (Stage) btnNewTask.getScene().getWindow();
        window.setScene(new Scene(root, 590, 600));
    }


    public void onCreateSaveButtonClick() throws IOException {
        System.out.printf("%s\n\n%s", titleTextField.getText(), descriptionTextArea.getText());
        todoList.addTodo(new TodoItem(titleTextField.getText(), descriptionTextArea.getText(), new Date(), false));
        // switch to home view
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage window = (Stage) btnCreateSave.getScene().getWindow();
        window.setScene(new Scene(root, 590, 300));

        VBox todoListDisplay = (VBox) root.lookup("#todoListDisplay");
        for (int idx = 0; idx < todoList.getLength(); idx++) {
            Label title = new Label(todoList.getItem(idx).getTitle());
            todoListDisplay.getChildren().add(title) ;
        }
    }

    public void onCreateCancelButtonClick() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage window = (Stage) btnCreateExit.getScene().getWindow();
        window.setScene(new Scene(root, 590, 300));

        VBox todoListDisplay = (VBox) root.lookup("#todoListDisplay");
        for (int idx = 0; idx < todoList.getLength(); idx++) {
            Label title = new Label(todoList.getItem(idx).getTitle());
            todoListDisplay.getChildren().add(title) ;
        }
    }




}
