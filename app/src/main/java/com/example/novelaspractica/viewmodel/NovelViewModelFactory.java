package com.example.novelaspractica.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.novelaspractica.repositories.NovelRepository;

public class NovelViewModelFactory implements ViewModelProvider.Factory {
    private final NovelRepository repository;

    public NovelViewModelFactory(NovelRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NovelViewModel.class)) {
            return (T) new NovelViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
