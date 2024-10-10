package com.example.novelaspractica;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "novel_table")
public class Novel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String author;
    private int year;
    private String synopsis;

    public Novel(String title, String author, int year, String synopsis) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.synopsis = synopsis;
    }

    // Getters y Setters
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

    public int getYear() {
        return year;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}

