package com.example.novelaspractica.repositories;

import androidx.lifecycle.LiveData;
import com.example.novelaspractica.Novel;
import com.example.novelaspractica.interfacesDao.NovelDao;
import java.util.List;

public class NovelRepository {
    private final NovelDao novelDao;
    private final LiveData<List<Novel>> allNovels;

    public NovelRepository(NovelDao novelDao) {
        this.novelDao = novelDao;
        this.allNovels = novelDao.getAllNovels(); // Método que debe estar en NovelDao
    }

    public void insert(Novel novel) {
        novelDao.insert(novel); // Asegúrate de que este método esté definido en NovelDao
    }

    public void delete(Novel novel) {
        novelDao.delete(novel); // Asegúrate de que este método esté definido en NovelDao
    }

    public LiveData<List<Novel>> getAllNovels() {
        return allNovels;
    }
}

