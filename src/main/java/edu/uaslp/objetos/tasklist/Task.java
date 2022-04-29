package edu.uaslp.objetos.tasklist;

import java.time.LocalDateTime;

public class Task {
    //Lo que debe de hacer una tarea
    private String name;
    private String description;
    private boolean band;
    private LocalDateTime deadline;

    public Task(String name, String description, LocalDateTime deadline, boolean band) {
        this.name = name;
        this.description = description;
        this.band = band;
        this.deadline = deadline;
    }

    public Task() {
        band=false;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return deadline;
    }

    public void setDueDate(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return band;
    }

    public void setDone(boolean band) {
        this.band = band;
    }

}
