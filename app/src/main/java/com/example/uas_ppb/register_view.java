package com.example.uas_ppb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class register_view extends AppCompatActivity {

    Button rgstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);

        rgstr = findViewById(R.id.register);

        rgstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicit = new Intent(register_view.this, home.class);
                startActivity(explicit);
            }
        });
    }
}