package com.example.novelaspractica;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "review_table")
public class Review {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String reviewText;
    private int novelId;

    public Review(String reviewText, int novelId) {
        this.reviewText = reviewText;
        this.novelId = novelId;
    }

    public Review(String reviewTitle, String reviewDescription, float rating) {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    public String getTitle() {
        return getTitle();
    }

    public String getDescription() {
        return getDescription();

    }

    public float getRating() {
        return getRating();
    }
}
