package com.example.novelaspractica.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.novelaspractica.Novel;
import com.example.novelaspractica.interfacesDao.NovelDao;

@Database(entities = {Novel.class}, version = 1)
public abstract class NovelDatabase extends RoomDatabase {
    private static NovelDatabase instance;

    public abstract NovelDao novelDao();

    public static synchronized NovelDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            NovelDatabase.class, "novel_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

