package com.example.novelaspractica;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class AddReviewActivity extends AppCompatActivity {

    private EditText editTextReviewTitle, editTextReviewDescription;
    private RatingBar ratingBar;
    private Button buttonSubmitReview;
    private ReviewViewModel reviewViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        // Inicializar elementos de la interfaz
        editTextReviewTitle = findViewById(R.id.editTextReviewTitle);
        editTextReviewDescription = findViewById(R.id.editTextReviewDescription);
        ratingBar = findViewById(R.id.ratingBar);
        buttonSubmitReview = findViewById(R.id.buttonSubmitReview);

        // Inicializar ViewModel
        reviewViewModel = new ViewModelProvider(this).get(ReviewViewModel.class);

        // Insertar reseña cuando se presiona el botón
        buttonSubmitReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reviewTitle = editTextReviewTitle.getText().toString().trim();
                String reviewDescription = editTextReviewDescription.getText().toString().trim();
                float rating = ratingBar.getRating();

                if (reviewTitle.isEmpty() || reviewDescription.isEmpty()) {
                    Toast.makeText(AddReviewActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Insertar la reseña en la base de datos
                    Review newReview = new Review(reviewTitle, reviewDescription, rating);
                    reviewViewModel.insert(newReview);
                    Toast.makeText(AddReviewActivity.this, "Reseña añadida", Toast.LENGTH_SHORT).show();
                    finish(); // Finaliza la actividad actual y regresa a la pantalla anterior
                }
            }
        });
    }
}

