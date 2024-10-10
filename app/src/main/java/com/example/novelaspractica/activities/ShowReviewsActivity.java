package com.example.novelaspractica.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.novelaspractica.R;
import com.example.novelaspractica.Review;
import com.example.novelaspractica.adapters.ReviewAdapter;
import com.example.novelaspractica.viewmodel.ReviewViewModel;
import java.util.List;

public class ShowReviewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;
    private ReviewViewModel reviewViewModel;
    private Button buttonBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reviews);

        // Inicializar RecyclerView y el adaptador
        recyclerView = findViewById(R.id.recyclerViewShowReviews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        reviewAdapter = new ReviewAdapter();
        recyclerView.setAdapter(reviewAdapter);

        // Configurar el ViewModel para observar las reseñas
        reviewViewModel = new ViewModelProvider(this).get(ReviewViewModel.class);
        reviewViewModel.getAllReviews().observe(this, new Observer<List<Review>>() {
            @Override
            public void onChanged(List<Review> reviews) {
                if (reviews != null && !reviews.isEmpty()) {
                    // Actualizar el adaptador con las reseñas
                    reviewAdapter.setReviews(reviews);
                } else {
                    Toast.makeText(ShowReviewsActivity.this, "No hay reseñas para mostrar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar botón para volver a la pantalla principal
        buttonBackToMain = findViewById(R.id.buttonBackToMain);
        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowReviewsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
