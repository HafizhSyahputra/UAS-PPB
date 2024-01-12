package com.example.uas_ppb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class login_view extends AppCompatActivity {

    Button lgn, rgst;

    ImageButton back;
    EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        lgn = findViewById(R.id.login);
        rgst = findViewById(R.id.register);
        back = findViewById(R.id.back);
        usernameEditText = findViewById(R.id.editTextText);
        passwordEditText = findViewById(R.id.editTextText2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_view.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_view.this, register_view.class);
                startActivity(intent);
            }
        });

        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(login_view.this, "Isikan username dan password.", Toast.LENGTH_SHORT).show();
                } else {
                    if (username.equals("putra") && password.equals("putra")) {
                        Intent explicit = new Intent(login_view.this, home.class);
                        startActivity(explicit);
                    } else {
                        Toast.makeText(login_view.this, "Username atau password salah.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
