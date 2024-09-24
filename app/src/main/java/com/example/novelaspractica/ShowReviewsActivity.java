package com.example.novelaspractica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class ShowReviewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ReviewViewModel reviewViewModel;
    private ReviewAdapter reviewAdapter;
    private Button buttonBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reviews);

        recyclerView = findViewById(R.id.recyclerViewShowReviews);
        buttonBackToMain = findViewById(R.id.buttonBackToMain);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        reviewAdapter = new ReviewAdapter();
        recyclerView.setAdapter(reviewAdapter);

        reviewViewModel = new ViewModelProvider(this).get(ReviewViewModel.class);

        // Observar los cambios en la lista de reseñas
        reviewViewModel.getAllReviews().observe(this, new Observer<List<Review>>() {
            @Override
            public void onChanged(List<Review> reviews) {
                if (reviews != null) {
                    reviewAdapter.setReviews(reviews); // Actualiza el adaptador con las reseñas
                }
            }
        });

        // Configurar el botón para volver a la pantalla principal
        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowReviewsActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finalizar la actividad actual
            }
        });
    }
}



