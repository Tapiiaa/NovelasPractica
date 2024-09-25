package com.example.novelaspractica;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Configurar el botón para iniciar sesión
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();

                if (username.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Por favor, introduce un nombre de usuario", Toast.LENGTH_SHORT).show();
                } else {
                    // Enlazar con la MainActivity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("USERNAME", username); // Pasar el nombre de usuario a la MainActivity
                    startActivity(intent);
                    finish(); // Finalizar la actividad de Login
                }
            }
        });
    }
}
