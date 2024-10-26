package com.example.novelaspractica.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.novelaspractica.R;
import com.example.novelaspractica.database.NovelDatabase; // Asegúrate de importar tu base de datos
import com.example.novelaspractica.Novel;
import com.example.novelaspractica.repositories.NovelRepository;
import com.example.novelaspractica.viewmodel.NovelViewModel;
import com.example.novelaspractica.viewmodel.NovelViewModelFactory;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonAddBook;
    private Button buttonSettings;
    private Button buttonBackup;
    private Button buttonRestore;
    private RecyclerView recyclerView;
    private NovelViewModel novelViewModel;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddBook = findViewById(R.id.buttonAddBook);
        buttonSettings = findViewById(R.id.buttonSettings);
        buttonBackup = findViewById(R.id.buttonBackup);
        buttonRestore = findViewById(R.id.buttonRestore);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Obtén la instancia de la base de datos y del NovelDao
        NovelDatabase database = NovelDatabase.getInstance(this); // Asegúrate de tener este método en tu clase NovelDatabase
        NovelRepository repository = new NovelRepository(database.novelDao()); // Aquí pasas el NovelDao

        // Crear la instancia del ViewModel
        NovelViewModelFactory factory = new NovelViewModelFactory(repository);
        novelViewModel = new ViewModelProvider(this, factory).get(NovelViewModel.class);

        // Observa los cambios en la lista de novelas
        novelViewModel.getAllNovels().observe(this, new Observer<List<Novel>>() {
            @Override
            public void onChanged(List<Novel> novels) {
                // Actualiza el adapter aquí
            }
        });

        buttonAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNovelActivity.class);
                startActivity(intent);
            }
        });

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        sharedPreferences = getSharedPreferences("com.example.novelaspractica_preferences", MODE_PRIVATE);
        applyUserSettings();
    }

    private void applyUserSettings() {
        boolean darkMode = sharedPreferences.getBoolean("dark_mode", false);
        if (darkMode) {
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.AppTheme);
        }
    }
}
