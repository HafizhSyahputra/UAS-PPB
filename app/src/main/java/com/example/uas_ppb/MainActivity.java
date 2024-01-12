package com.example.uas_ppb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button msk, rgst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msk = findViewById(R.id.login);
        rgst = findViewById(R.id.register);

        msk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicit = new Intent(MainActivity.this, login_view.class);
                startActivity(explicit);
            }
        });

        rgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicit = new Intent(MainActivity.this, register_view.class);
                startActivity(explicit);
            }
        });
    }
}