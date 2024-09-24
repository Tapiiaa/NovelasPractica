package com.example.novelaspractica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonAddBook;
    private RecyclerView recyclerView;
    private NovelViewModel novelViewModel;
    private NovelAdapter novelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddBook = findViewById(R.id.buttonAddBook);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        novelAdapter = new NovelAdapter();
        recyclerView.setAdapter(novelAdapter);

        novelViewModel = new ViewModelProvider(this).get(NovelViewModel.class);

        novelViewModel.getAllNovels().observe(this, new Observer<List<Novel>>() {
            @Override
            public void onChanged(List<Novel> novels) {
                novelAdapter.setNovels(novels);
            }
        });

        buttonAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Agregar novela no implementado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
