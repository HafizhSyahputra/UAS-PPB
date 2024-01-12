package com.example.uas_ppb;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class airplaneFragment extends Fragment {
    Button pesan;
    ImageButton h1, h2, h3, h4;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_airplane, container, false);

        h1 = root.findViewById(R.id.h1);
        h2 = root.findViewById(R.id.h2);
        h3 = root.findViewById(R.id.h3);
        h4 = root.findViewById(R.id.h4);
        pesan = root.findViewById(R.id.pesan);

        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), belitiket.class);
                startActivity(intent);
            }
        });

        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), detail_pesawat.class);
                startActivity(intent);
            }
        });

        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), detail_pesawat2.class);
                startActivity(intent);
            }
        });

        h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), detail_pesawat3.class);
                startActivity(intent);
            }
        });

        h4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), detail_pesawat4.class);
                startActivity(intent);
            }
        });

        return root;
    }
}
