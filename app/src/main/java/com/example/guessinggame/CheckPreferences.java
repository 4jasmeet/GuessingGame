package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class CheckPreferences extends AppCompatActivity {

    TextView prefTextView;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_preferences);

        prefTextView = findViewById(R.id.prefTextView);
        sp = getSharedPreferences("userInfo", MODE_PRIVATE);

        String name = sp.getString("name", "Empty");
        prefTextView.setText(name);

    }
}