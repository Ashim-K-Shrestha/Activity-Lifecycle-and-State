package com.example.labfive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * SecondActivity defines the second activity in the app. It is
 * launched from an intent with a message, and sends an intent
 * back with a second message.
 */
public class SecondActivity extends AppCompatActivity {
    // defining a key for the intent extra to send a reply message
    public static final String EXTRA_REPLY = "com.example.android.MainActivity.extra.REPLY";

    // variable to hold the reply message
    private EditText mReply;

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    /**
     * @param savedInstanceState The current state data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // referencing to the editText textView and assigning it to the variable created
        mReply = findViewById(R.id.editText_second);

        // fetching the intent that launched this second activity
        Intent intent = getIntent();

        // getting the string with the message from the intent extras using the static variable as the key
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // getting a reference to the textView with the message
        TextView textView = findViewById(R.id.text_message);

        // setting the message from the textView to the string from the intent extra
        textView.setText(message);

    }

    // lifecycle methods
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    /**
     * Handling the function for the reply button where the message from the
     * second EditText is fetched, an new intent is created and the reply is
     * sent to the main activity.
     *
     * @param view The view (Button) that was clicked.
     */
    public void returnReply(View view) {
        // fetching the message from EditText view into a string variable
        String reply = mReply.getText().toString();

        // Creating a new intent for the response, we can not reuse the previous intent
        Intent replyIntent = new Intent();

        // adding the string from the intent as an extra intent where EXTRA_REPLY is the key and reply is the value
        replyIntent.putExtra(EXTRA_REPLY, reply);

        // setting the results to RESULT_OK for the successful response
        setResult(RESULT_OK, replyIntent);

        Log.d(LOG_TAG, "End SecondActivity");

        // closing the activity
        finish();
    }
}