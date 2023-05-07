package com.moinonemoi.todolist;



import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String text;
    private int priority;

    public Note(int id, String text, int priority) {
        this.id = id;
        this.text = text;
        this.priority = priority;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }


}
