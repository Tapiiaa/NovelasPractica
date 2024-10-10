package com.example.novelaspractica;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "novel_table")
public class Novel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private final String novelName;  // Cambiado de title a novelName
    private String author;
    private int year;
    private String synopsis;

    // Constructor que inicializa todos los campos
    public Novel(String novelName, String author, int year, String synopsis) {
        this.novelName = novelName;  // Cambiado de title a novelName
        this.author = author;
        this.year = year;
        this.synopsis = synopsis;
    }

    // Getters
    public int getId() { return id; }
    public String getNovelName() { return novelName; }  // Cambiado de getTitle a getNovelName
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public String getSynopsis() { return synopsis; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setAuthor(String author) { this.author = author; }
    public void setYear(int year) { this.year = year; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public String getTitle() {
        return novelName;
    }
}
