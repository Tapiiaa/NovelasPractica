package com.example.novelaspractica.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.novelaspractica.R;
import com.example.novelaspractica.Review;
import com.example.novelaspractica.viewmodel.ReviewViewModel;

public class AddReviewActivity extends AppCompatActivity {

    private EditText editTextReview;
    private Button buttonAddReview;
    private ReviewViewModel reviewViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        // Inicializar vistas
        editTextReview = findViewById(R.id.editTextReview);
        buttonAddReview = findViewById(R.id.buttonAddReview);

        // Inicializar ViewModel
        reviewViewModel = new ViewModelProvider(this).get(ReviewViewModel.class);

        // Configurar el botón para agregar reseñas
        buttonAddReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reviewText = editTextReview.getText().toString().trim();

                if (!reviewText.isEmpty()) {
                    Review review = new Review(reviewText, 1); // Usa el ID adecuado de la novela
                    reviewViewModel.insert(review);
                    Toast.makeText(AddReviewActivity.this, "Reseña agregada", Toast.LENGTH_SHORT).show();
                    editTextReview.setText("");
                } else {
                    Toast.makeText(AddReviewActivity.this, "Ingrese una reseña", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

