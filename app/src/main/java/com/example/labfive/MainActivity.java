package com.example.labfive;

import androidx.annotation.NonNull;
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
    // declaring private variable for the count
    private int Count = 0;

    // declaring variable for the count text view
    private TextView CountView;
    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data.
     *
     * Activities have the ability,to restore themselves to a previous state using
     * the data stored in this bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // referring to the parent class
        super.onCreate(savedInstanceState);
        // setting this layout as the main one when the app starts
        setContentView(R.layout.activity_main);

        // referencing to the text view using the id
        CountView = (TextView) findViewById(R.id.show_count);

        // if savedInstanceState is not null then
        if (savedInstanceState != null) {
            // setting the value from count to the variable declared
            Count=savedInstanceState.getInt("count");
            // setting the value of variable to the text view
            CountView.setText(""+Count);
        }
    }
    /**
     *  @param view The view (Button) that was clicked.
     *
     *  This function handles the value of the counter when the button is clicked
     */
    public void IncreaseCount(View view) {
        // increment in count value
        Count++;
        // if Count is not null then
        if (CountView != null)
            // setting the value of the variable to the text view
            CountView.setText(Integer.toString(Count));
    }
    /**
     * Initializes the activity.
     *
     * @param outState  the state going out (being saved, not read)
     *
     * @NonNull means the method should not return null
     *
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        // calling the super class to save any view hierarchy
        super.onSaveInstanceState(outState);
        // referencing and assigning the id with the text view
        EditText text=findViewById(R.id.editTextMessage);
        // fetching the text from the text view
        CharSequence data=text.getText();
        // putCharSequence() inserts a charSequence value into the bundle replacing the value of the given key
        outState.putCharSequence("data",data);
        outState.putInt("count",Count);
    }
    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data.
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // saving the data into data CharSequence variable
        CharSequence data=savedInstanceState.getCharSequence("data");
        // referencing and assigning the id with the editText view
        EditText text=findViewById(R.id.editTextMessage);
        // setting the data into editText view
        text.setText(data);
    }
}