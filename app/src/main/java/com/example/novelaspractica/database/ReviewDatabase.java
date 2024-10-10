package com.example.novelaspractica.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.novelaspractica.Review;
import com.example.novelaspractica.interfacesDao.ReviewDao;

@Database(entities = {Review.class}, version = 2, exportSchema = false)
public abstract class ReviewDatabase extends RoomDatabase {

    private static ReviewDatabase instance;

    public abstract ReviewDao reviewDao();

    public static synchronized ReviewDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            ReviewDatabase.class, "review_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}


