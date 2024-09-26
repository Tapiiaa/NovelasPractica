package com.example.novelaspractica.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.novelaspractica.Novel;
import com.example.novelaspractica.viewmodel.NovelViewModel;
import com.example.novelaspractica.R;
import com.example.novelaspractica.adapters.NovelAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonAddBook, buttonDeleteBook, buttonShowAll, buttonAddReview, buttonShowReviews;
    private EditText editTextNovelName, editTextSearchNovel;
    private RecyclerView recyclerView;
    private NovelViewModel novelViewModel;
    private NovelAdapter novelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos de la interfaz
        editTextNovelName = findViewById(R.id.editTextNovelName);
        editTextSearchNovel = findViewById(R.id.editTextSearchNovel);
        buttonAddBook = findViewById(R.id.buttonAddBook);
        buttonDeleteBook = findViewById(R.id.buttonDeleteBook);
        buttonShowAll = findViewById(R.id.buttonShowAll);
        buttonAddReview = findViewById(R.id.buttonAddReview);
        buttonShowReviews = findViewById(R.id.buttonShowReviews);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        novelAdapter = new NovelAdapter();
        recyclerView.setAdapter(novelAdapter);

        // ViewModel para gestionar la base de datos
        novelViewModel = new ViewModelProvider(this).get(NovelViewModel.class);

        novelViewModel.getAllNovels().observe(this, new Observer<List<Novel>>() {
            @Override
            public void onChanged(List<Novel> novels) {
                novelAdapter.setNovels(novels);
            }
        });

        // Agregar una nueva novela
        buttonAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String novelName = editTextNovelName.getText().toString().trim();
                if (!novelName.isEmpty()) {
                    Novel newNovel = new Novel(novelName, "Autor Desconocido", 2023, "Sinopsis no disponible");
                    novelViewModel.insert(newNovel);
                    editTextNovelName.setText(""); // Limpiar el campo de texto
                    Toast.makeText(MainActivity.this, "Novela agregada", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, ingrese un nombre para la novela", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Redirigir a la pantalla para mostrar todas las novelas
        buttonShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowNovelsActivity.class);
                startActivity(intent);
            }
        });

        // Buscar y eliminar novela por nombre
        buttonDeleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchName = editTextSearchNovel.getText().toString().trim();
                if (!searchName.isEmpty()) {
                    novelViewModel.getAllNovels().observe(MainActivity.this, new Observer<List<Novel>>() {
                        @Override
                        public void onChanged(List<Novel> novels) {
                            for (Novel novel : novels) {
                                if (novel.getTitle().equalsIgnoreCase(searchName)) {
                                    novelViewModel.delete(novel);
                                    Toast.makeText(MainActivity.this, "Novela eliminada", Toast.LENGTH_SHORT).show();
                                    editTextSearchNovel.setText(""); // Limpiar el campo de texto
                                    return;
                                }
                            }
                            Toast.makeText(MainActivity.this, "Novela no encontrada", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, ingrese un nombre para buscar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Redirigir a la pantalla para agregar reseña
        buttonAddReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddReviewActivity.class);
                startActivity(intent);
            }
        });

        // Redirigir a la pantalla para mostrar todas las reseñas
        buttonShowReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowReviewsActivity.class);
                startActivity(intent);
            }
        });
    }
}


