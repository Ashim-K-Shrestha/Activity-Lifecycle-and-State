package com.example.labfive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * SecondActivity defines the second activity in the app. It is
 * launched from an intent with a message, and sends an intent
 * back with a second message.
 */
public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "ca.nbcc.shoppinglist.extra.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void addItem (View view) {
        Intent replyIntent=new Intent();
        String message=((Button)view).getText().toString();
        replyIntent.putExtra(EXTRA_MESSAGE, message);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}