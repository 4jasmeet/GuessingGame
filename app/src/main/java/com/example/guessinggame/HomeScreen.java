package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class HomeScreen extends AppCompatActivity {


    TextView  playerNameText, resultTextView;
    EditText guessEditText;
    Button guessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //Registering components
        playerNameText = findViewById(R.id.playerNameText);
        resultTextView = findViewById(R.id.resultTextView);
        guessEditText = findViewById(R.id.guessEditText);
        guessButton = findViewById(R.id.guessButton);

        //Get the name and store this in an intent obj
        Intent in = getIntent();
        //To retrieve the name, we use the unique name we had given it while sending and we can store it in a variable
        String playerName = in.getStringExtra("playername");

        //Displaying the name with a welcome message
        playerNameText.setText("Welcome " + playerName + "!");

        //To choose a random number, we will use random class and to access it, we'll have to first create an object
        Random random = new Random();
        //specify the bound 11 means less than NOT EQUAL TO
        int number = random.nextInt(11);

        //Create a listener for the guessButton
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //First we'll store the guess of the user. It will be in string so we'll convert it into int
                int guess = Integer.parseInt(guessEditText.getText().toString());

                //Set conditions and display result accordingly
                if(guess > number)
                {
                    resultTextView.setText("Your guess was too high!");
                }
                else if (guess < number)
                {
                    resultTextView.setText("Your guess was too low!");
                }
                else
                {
                    resultTextView.setText("Congrats! You won :)");
                }


            }
        });

    }


}