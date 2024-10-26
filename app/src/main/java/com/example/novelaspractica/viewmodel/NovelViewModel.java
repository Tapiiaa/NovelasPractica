package com.example.novelaspractica.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.novelaspractica.Novel;
import com.example.novelaspractica.repositories.NovelRepository;

import java.util.List;

public class NovelViewModel extends ViewModel {
    private final NovelRepository repository;
    private final LiveData<List<Novel>> allNovels;

    public NovelViewModel(NovelRepository repository) {
        this.repository = repository;
        allNovels = repository.getAllNovels(); // Asegúrate de que tu repositorio tenga este método
    }

    public void insert(Novel novel) {
        repository.insert(novel);
    }

    public void delete(Novel novel) {
        repository.delete(novel);
    }

    public LiveData<List<Novel>> getAllNovels() {
        return allNovels;
    }
}
