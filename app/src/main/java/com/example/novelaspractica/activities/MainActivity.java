package com.example.novelaspractica.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.novelaspractica.R;
import com.example.novelaspractica.adapters.NovelAdapter;
import com.example.novelaspractica.Novel;
import com.example.novelaspractica.repositories.NovelRepository;
import com.example.novelaspractica.viewmodel.NovelViewModel;

public class MainActivity extends AppCompatActivity {

    private Button buttonAddNovel, buttonSettings, buttonBackup, buttonRestore;
    private RecyclerView recyclerView;
    private NovelViewModel novelViewModel;
    private NovelAdapter novelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddNovel = findViewById(R.id.buttonAddNovel);
        buttonSettings = findViewById(R.id.buttonSettings);
        buttonBackup = findViewById(R.id.buttonBackup);
        buttonRestore = findViewById(R.id.buttonRestore);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        novelAdapter = new NovelAdapter();
        recyclerView.setAdapter(novelAdapter);

        novelViewModel = new ViewModelProvider(this).get(NovelViewModel.class);

        // Button Click Listeners
        buttonAddNovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNovel();
            }
        });

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        buttonBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BackupActivity.class);
                startActivity(intent);
            }
        });

        buttonRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RestoreActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addNovel() {
        // Replace with actual input
        EditText editTextNovelName = findViewById(R.id.editTextNovelName);
        String novelName = editTextNovelName.getText().toString().trim();

        if (novelName.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa un nombre de novela", Toast.LENGTH_SHORT).show();
            return;
        }

        Novel novel = new Novel(novelName, null);
        novelViewModel.insert(novel);
        Toast.makeText(this, "Novela añadida", Toast.LENGTH_SHORT).show();
        editTextNovelName.setText(""); // Clear input field
    }
}
