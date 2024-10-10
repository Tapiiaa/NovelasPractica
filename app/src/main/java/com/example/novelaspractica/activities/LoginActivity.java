package com.example.novelaspractica.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.novelaspractica.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();

                //Conectar loginactivity con mainactivity
                if (username.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Por favor, introduce un nombre de usuario", Toast.LENGTH_SHORT).show();
                } else {
                    // Crear el Intent para abrir MainActivity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("USERNAME", username); // Pasar el nombre de usuario
                    startActivity(intent);

//                if (username.isEmpty()) {
//                    Toast.makeText(LoginActivity.this, "Por favor, introduce un nombre de usuario", Toast.LENGTH_SHORT).show();
//                } else {
//                    // Crear el Intent para abrir MainActivity
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    intent.putExtra("USERNAME", username); // Pasar el nombre de usuario
//                    startActivity(intent);

                }
            }
        });
    }
}
