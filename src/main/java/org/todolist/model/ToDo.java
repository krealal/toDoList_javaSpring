package org.todolist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "toDoKRA")
public class ToDo {
    @Id
    private String id;
    private String toDo;
    private String description;
    private boolean isDone;

    public String getId() {
        return id;
    }

    public ToDo(String id, String toDo, boolean isDone) {
        this.id = id;
        this.toDo = toDo;
        this.isDone = isDone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id='" + id + '\'' +
                ", toDo='" + toDo + '\'' +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}


