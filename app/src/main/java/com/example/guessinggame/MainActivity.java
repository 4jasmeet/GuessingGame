package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText playerEditText;
    Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerEditText = findViewById(R.id.playerEditText);
        startButton = findViewById(R.id.startButton);

        //We use intent to send info from one activity to another
        //In this case we'll need to share the name to HomeScreen
        //Listeners are use to check when a button is pressed (button.setOnClickListener)
        //OnClickListener is an interface and interfaces contains some functions which have to be compulsory overridden
        //Android Studio will do overriding and do registering on its own, we just have to create intent OnClickListener

        //When start button is pressed the action to be performed is written in this
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //To pick the player's name and send it to another activity
                //Get text doesn't return a string value, it returns an editable object.
                //The editable object needs to be converted to string so .toString is added
                //STORING THE NAME
                String playerName = playerEditText.getText().toString();

                //Now we can send it to other activity, for that we need to create an object of the intent
                //We need to specify from and to which activity its going
                //i.e. from MainActivity's 'this' listener to HomeScreen.class
                Intent in =new Intent(MainActivity.this, HomeScreen.class);

                //To send the name to other activity, we use putExtra(name, actual value)
                //ACTUALLY SENDING NAME TO THE OTHER ACTIVITY
                in.putExtra("playername", playerName);

                //Intent is created, to start it we use the obj of intent class we created
                startActivity(in);


            }
        });
    }
}