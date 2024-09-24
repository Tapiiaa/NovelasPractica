package com.example.novelaspractica;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "review_table")
public class Review {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String description;
    private float rating;

    public Review(String title, String description, float rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public float getRating() { return rating; }

    public void setId(int id) { this.id = id; }
}
