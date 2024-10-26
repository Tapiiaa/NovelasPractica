package com.example.novelaspractica.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.novelaspractica.interfacesDao.NovelDao;
import com.example.novelaspractica.Novel;

@Database(entities = {Novel.class}, version = 2) // Aumentar el número de versión aquí
public abstract class NovelDatabase extends RoomDatabase {

    private static NovelDatabase instance;

    public abstract NovelDao novelDao();

    public static synchronized NovelDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            NovelDatabase.class, "novel_database")
                    .fallbackToDestructiveMigration() // Eliminar datos viejos si la migración falla
                    .build();
        }
        return instance;
    }
}
