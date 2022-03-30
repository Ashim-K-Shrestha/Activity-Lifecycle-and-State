package com.example.labfive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // creating a constant for the intent extra
    public static final int TEXT_REQUEST = 1;

    // initializing an object of class ShopList for storing the products
    private ShopList items = new ShopList();

    //
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fetching the intent from the second activity
        Intent intent = getIntent();

        // if the instances are saved and the list hashmap object is not null then,
        if ((savedInstanceState != null) && (savedInstanceState.getSerializable("list") != null)) {
            // storing the element of object 'list' into new hashmap object 'l'
            HashMap<String, Integer> l = (HashMap<String, Integer>) savedInstanceState.getSerializable("list");
            // assigning the textView with the id
            TextView tv = findViewById(R.id.textView);
            // setting the text to blank
            tv.setText("");
            // creating a set of the keys only from 'l' object and storing into the 'k' variable
            for (String k : l.keySet()) {
                // getting the elements similar to 'k' elements from 'l' object and storing into the new variable
                String s = l.get(k).toString() + " " + k + "\n";
                // setting the textView content with the elements from the new variable
                tv.setText(tv.getText() + s);
                // adding each items into the 'items' hashmap object
                for (int i = 0; i < l.get(k); i++) {
                    items.addItem(k);
                }
            }
        }
    }

    public void launchSecondActivity(View view) {
        // creating a new intent for launching the second activity
        Intent intent = new Intent(this, SecondActivity.class);
        // starting the second activity with results
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // inserting a serializable value into the bundle using the list as the key and its elements as the values
        savedInstanceState.putSerializable("list", items.getItems());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // if the requestCode is equal to TEXT_REQUEST
        if (requestCode == TEXT_REQUEST) {
            // if the resultCode is equal to RESULT_OK
            if (resultCode == RESULT_OK) {
                // storing the
                String item = data.getStringExtra(SecondActivity.EXTRA_MESSAGE);
                items.addItem(item);
            }
            // executing the function created below for displaying the list of products
            drawView();
        }
    }

    public void drawView() {
        HashMap<String, Integer> l = items.getItems();
        TextView tv = findViewById(R.id.textView);
        tv.setText("");
        for (String k : l.keySet()) {
            String s = l.get(k).toString() + " " + k + "\n";
            tv.setText(tv.getText() + s);
        }
    }
}