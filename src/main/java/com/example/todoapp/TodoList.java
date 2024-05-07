package com.example.todoapp;

import java.util.ArrayList;
import java.util.Date;

public class TodoList {

    private ArrayList<TodoItem> todoList;
    private static TodoList singleInstance;

    private TodoList() {
        this.todoList = new ArrayList<>(10);

        // add sample todo Items
        addTodo(new TodoItem("Get milk", "get milk from safeway", new Date(), false));
        addTodo(new TodoItem("Math Home Work", "Assignments 10.4-10.5", new Date(), true));
    }

    public static TodoList getInstance() {
        if (singleInstance == null) {
            singleInstance = new TodoList();
        }
        return singleInstance;
    }

    public void addTodo(TodoItem newItem) {
        todoList.add(newItem);
    }

    public void removeTodo() {

    }

    public int getLength() {
        return todoList.size();
    }

    public TodoItem getItem(int index) {
        return todoList.get(index);
    }





}
