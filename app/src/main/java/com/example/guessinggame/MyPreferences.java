package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyPreferences extends AppCompatActivity {

    EditText prefName; Button saveButton, checkButton;
    SharedPreferences sp; SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_preferences);

        prefName = findViewById(R.id.prefName);
        saveButton = findViewById(R.id.savePrefButton);
        checkButton = findViewById(R.id.checkPrefButton);


        sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        editor = sp.edit();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = prefName.getText().toString();
                editor.putString("name", name);
                editor.apply();
                Toast.makeText(MyPreferences.this,"Information saved.", Toast.LENGTH_SHORT).show();

            }
        });
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MyPreferences.this, CheckPreferences.class);
                startActivity(in);
            }
        });

    }
}