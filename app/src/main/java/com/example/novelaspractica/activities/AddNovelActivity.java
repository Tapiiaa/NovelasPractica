package com.example.novelaspractica.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.novelaspractica.R;
import com.example.novelaspractica.Novel;
import com.example.novelaspractica.viewmodel.NovelViewModel;

public class AddNovelActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextAuthor;
    private NovelViewModel novelViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_novel);  // Asegúrate de que esto coincida

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextAuthor = findViewById(R.id.editTextAuthor);
        Button buttonSave = findViewById(R.id.buttonSave);

        novelViewModel = new ViewModelProvider(this).get(NovelViewModel.class);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNovel();
            }
        });
    }

    private void saveNovel() {
        String title = editTextTitle.getText().toString();
        String author = editTextAuthor.getText().toString();

        if (title.isEmpty() || author.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        Novel novel = new Novel(title, author);
        novelViewModel.insert(novel);
        Toast.makeText(this, "Novela añadida.", Toast.LENGTH_SHORT).show();
        finish(); // Cerrar la actividad
    }
}
