package com.example.novelaspractica.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.novelaspractica.Novel;
import com.example.novelaspractica.repositories.NovelRepository;

import java.util.List;

public class NovelViewModel extends AndroidViewModel {
    private NovelRepository repository;
    private LiveData<List<Novel>> allNovels;

    public NovelViewModel(@NonNull Application application) {
        super(application);
        repository = new NovelRepository(application);
        allNovels = repository.getAllNovels();
    }

    public LiveData<List<Novel>> getAllNovels() {
        return allNovels;
    }

    public void insert(Novel novel) {
        repository.insert(novel);
    }

    public void delete(Novel novel) {
        repository.delete(novel);
    }
}
