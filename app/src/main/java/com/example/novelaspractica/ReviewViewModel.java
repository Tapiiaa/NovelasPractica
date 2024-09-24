package com.example.novelaspractica;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ReviewViewModel extends AndroidViewModel {

    private ReviewRepository repository;
    private LiveData<List<Review>> allReviews;

    public ReviewViewModel(@NonNull Application application) {
        super(application);
        repository = new ReviewRepository(application);
        allReviews = repository.getAllReviews();
    }

    public LiveData<List<Review>> getAllReviews() {
        return allReviews;
    }

    public void insert(Review review) {
        repository.insert(review);
    }

    public void delete(Review review) {
        repository.delete(review);
    }
}
