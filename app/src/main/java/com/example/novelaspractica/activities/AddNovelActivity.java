package com.example.novelaspractica.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.novelaspractica.Novel;
import com.example.novelaspractica.R;
import com.example.novelaspractica.database.NovelDatabase;
import com.example.novelaspractica.repositories.NovelRepository;
import com.example.novelaspractica.viewmodel.NovelViewModel;
import com.example.novelaspractica.viewmodel.NovelViewModelFactory;

public class AddNovelActivity extends AppCompatActivity {
    private EditText editTextNovelName;
    private Button buttonSave;
    private NovelViewModel novelViewModel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_novel);

        editTextNovelName = findViewById(R.id.editTextNovelName);
        buttonSave = findViewById(R.id.buttonSave);

        NovelRepository repository = new NovelRepository(NovelDatabase.getInstance(this).novelDao());
        NovelViewModelFactory factory = new NovelViewModelFactory(repository);
        novelViewModel = new ViewModelProvider(this, factory).get(NovelViewModel.class);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String novelName = editTextNovelName.getText().toString().trim();
                if (!novelName.isEmpty()) {
                    Novel novel = new Novel(novelName, null);
                    novelViewModel.insert(novel);
                    Toast.makeText(AddNovelActivity.this, "Novela añadida", Toast.LENGTH_SHORT).show();
                    finish(); // Cierra la actividad y vuelve a MainActivity
                } else {
                    Toast.makeText(AddNovelActivity.this, "Por favor ingresa un nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
