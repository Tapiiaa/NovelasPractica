package com.example.novelaspractica;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReviewDao {
    @Insert
    void insert(Review review);

    @Delete
    void delete(Review review);

    @Query("SELECT * FROM review_table ORDER BY id ASC")
    LiveData<List<Review>> getAllReviews();
}


