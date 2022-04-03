package com.example.labfive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // creating a constant for the intent extra
    public static final int TEXT_REQUEST = 1;

    // variable for the count value
    int count = 0;

    // defining a variable for the count value
    private TextView count_view;
    private Button count_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigning and referencing the view to the variable
        count_view = findViewById(R.id.textView);
        count_button = findViewById(R.id.button11);


        // using anonymous function because function is declared after 'new' keyword instead of object name
        // setting an onClick listener for the count button to increase the count when clicked
        count_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // increment in the value of variable
                count++;
                // count+"" is done to convert into string
                // setting the value of the counter to the textView
                count_view.setText(count+"");
            }
        });

        // Fetching the intent from the second activity
        Intent intent = getIntent();
    }

    public void launchSecondActivity(View view) {
        // creating a new intent for launching the second activity
        Intent intent = new Intent(this, SecondActivity.class);
        // starting the second activity with results
        startActivityForResult(intent, TEXT_REQUEST);
    }
}