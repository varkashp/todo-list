package com.example.todoapp;

import java.util.Date;

public class TodoItem {

    private String title;
    private String description;
    private Date dueDate;
    private Boolean isPriority;

    public TodoItem(String title, String description, Date dueDate, Boolean isPriority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isPriority = isPriority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Boolean getPriority() {
        return isPriority;
    }
}
