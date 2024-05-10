package com.example.todoapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;


public class TodoListController {
    @FXML
    private Button btnNewTask, btnCreateSave, btnCreateExit;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private DatePicker CreatedatePicker;


    private Boolean priorityValue = false;

    private Date dateSet;

    TodoList todoList =  TodoList.getInstance();

    @FXML
    protected void onCreateButtonClick () throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Task.fxml"));
        Stage window = (Stage) btnNewTask.getScene().getWindow();
        window.setScene(new Scene(root, 590, 600));
    }


    public void onCreateSaveButtonClick() throws IOException {
        System.out.printf("%s\n\n%s", titleTextField.getText(), descriptionTextArea.getText());

        if (dateSet == null) {
            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR_OF_DAY, 0);
            dateSet = today.getTime();
        }

        todoList.addTodo(new TodoItem(titleTextField.getText(), descriptionTextArea.getText(), dateSet, priorityValue));
        // switch to home view
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage window = (Stage) btnCreateSave.getScene().getWindow();
        window.setScene(new Scene(root, 785, 500));

        VBox todoListDisplay = (VBox) root.lookup("#todoListDisplay");
        TodoListApp.addTasksToView(todoListDisplay, todoList);
    }

    public void onCreateCancelButtonClick() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage window = (Stage) btnCreateExit.getScene().getWindow();
        window.setScene(new Scene(root, 785, 500));

        VBox todoListDisplay = (VBox) root.lookup("#todoListDisplay");
        TodoListApp.addTasksToView(todoListDisplay, todoList);
    }

    public void onClickedAnchor(MouseEvent mouseEvent) throws IOException {
        AnchorPane anchorPane = (AnchorPane) mouseEvent.getSource();


        Parent root = FXMLLoader.load(getClass().getResource("Task.fxml"));
        Stage window = (Stage) anchorPane.getScene().getWindow();
        Scene scene = new Scene(root, 590, 600);
        window.setScene(scene);

    }

    public void onPriorityClick() {
        boolean b = !(priorityValue);
        priorityValue = b;
    }


    public void onDateSetCreate(ActionEvent event) {
        LocalDate localDate = CreatedatePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        dateSet = Date.from(instant);
    }

    public void onDeleteButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        AnchorPane anchorPane = (AnchorPane) button.getParent();
        Text IDtext = (Text) anchorPane.lookup("#textID");
        int i = Integer.valueOf(IDtext.getText());

        todoList.deleteItem(i);
    }
}

