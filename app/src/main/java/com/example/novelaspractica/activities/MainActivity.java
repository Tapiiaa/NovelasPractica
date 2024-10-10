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
import com.example.novelaspractica.SyncDataTask;
import com.example.novelaspractica.viewmodel.ReviewViewModel;
import com.example.novelaspractica.NotificationHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;
    private ReviewViewModel reviewViewModel;
    private Button buttonSyncData, buttonAddReview, buttonShowReviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        recyclerView = findViewById(R.id.recyclerView);
        buttonSyncData = findViewById(R.id.buttonSyncData);
        buttonAddReview = findViewById(R.id.buttonAddReview);
        buttonShowReviews = findViewById(R.id.buttonShowReviews);

        // Configurar RecyclerView y el adaptador
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
                    reviewAdapter.setReviews(reviews);
                } else {
                    Toast.makeText(MainActivity.this, "No hay reseñas para mostrar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar el botón de sincronización de datos
        buttonSyncData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear el canal de notificación si no está creado
                NotificationHelper.createNotificationChannel(MainActivity.this);

                // Ejecutar la tarea de sincronización
                new SyncDataTask(MainActivity.this).execute();
            }
        });

        // Configurar el botón para agregar reseñas
        buttonAddReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddReviewActivity.class);
                startActivity(intent);
            }
        });

        // Configurar el botón para mostrar reseñas
        buttonShowReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowReviewsActivity.class);
                startActivity(intent);
            }
        });
    }
}
