package com.example.novelaspractica;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReviewRepository {

    private ReviewDao reviewDao;
    private LiveData<List<Review>> allReviews;
    private ExecutorService executorService;

    public ReviewRepository(Application application) {
        ReviewDatabase database = ReviewDatabase.getInstance(application);
        reviewDao = database.reviewDao();
        allReviews = reviewDao.getAllReviews();
        executorService = Executors.newFixedThreadPool(2);
    }

    public void insert(Review review) {
        executorService.execute(() -> reviewDao.insert(review));
    }

    public void delete(Review review) {
        executorService.execute(() -> reviewDao.delete(review));
    }

    public LiveData<List<Review>> getAllReviews() {
        return allReviews;
    }
}
