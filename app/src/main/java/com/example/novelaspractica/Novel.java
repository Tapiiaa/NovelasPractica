package com.example.novelaspractica;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "novel_table")
public class Novel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String author;

    public Novel(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

