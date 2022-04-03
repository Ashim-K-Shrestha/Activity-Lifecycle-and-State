package com.example.labfive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // declaring the constant for LOG_TAG variable that uses the class as its tag
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    // defining the key for the intent extra
    public static final String EXTRA_MESSAGE = "com.example.android.SecondActivity.extra.MESSAGE";

    // declaring a private variable for storing the EditText message
    private EditText mMessageEditText;

    // defining a key for a particular response
    public static final int TEXT_REQUEST = 1;

    // defining a variable for the reply header
    private TextView mReplyHeadTextView;
    // declaring a variable for the reply text message
    private TextView mReplyTextView;

    /**
     * @param savedInstanceState The current state data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // super keyword refers to parent class object
        super.onCreate(savedInstanceState);
        // setting the XML file as your main layout when the app starts
        setContentView(R.layout.activity_main);

        // logging the events of the onCreate method
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        // assigning the created variable to the editText view using id
        mMessageEditText = findViewById(R.id.editText_main);

        // assigning and referencing the views (header and reply textViews) elements to the variables
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        // Restore the state.
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");

            // if isVisible is not null
            if (isVisible) {
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                // fetching the text from the bundle and setting it to the textView
                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
                // making the reply text visible
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    // lifecycle callback methods
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
     * Method to save the data of the activity when the state of the activity is changed
     *
     * This method is mostly called during onStop() or the onPause() because the activity is most likely to be
     * destroyed or recreated during these phases
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            // adding the reply text into the bundle
            outState.putString("reply_text", mReplyTextView.getText().toString());
        }
    }

    /**
     * When the send button is clicked, the value of the EditText is fetched,
     * an intent is created and the second activity is launched with that intent
     * along with the data.
     *
     * @param view The view (Button) that was clicked.
     *
     * The TwoActivities app contains two activities and sends messages
     * (intents) between them.
     */
    public void launchSecondActivity(View view) {
        // Displaying the message in the logcat panel
        Log.d(LOG_TAG, "Button clicked!");

        /**
         * Initializing the object using the Intent constructor class.
         * Intent is used to send data among components and are of two types;
         *
         *  1) Explicit - we know the target component of the intent
         *  2) Implicit - unknown target component but known function to be performed
         *
         * Explicit intent is used here.
         *
         * @param this focuses on MainActivity class and secondActivity class
         */
        Intent intent = new Intent(this, SecondActivity.class);

        // setting the value into the new variable as a string
        String message = mMessageEditText.getText().toString();

        // using intent extras (bundle of key value pairs) to send data
        // adding the message to the intent as an extra using the EXTRA_MESSAGE as the key and string as the value
        intent.putExtra(EXTRA_MESSAGE, message);

        // calling the startActivity method with the intent as the argument
        //startActivity(intent);

        // startActivityForResult is used by an activity to receive data from an intent
        // using TEXT_REQUEST as the argument for the intent
        startActivityForResult(intent, TEXT_REQUEST);
    }

    /**
     * method to handle the return data or the reply from the second activity
     *
     * @param requestCode request code for the second activity.
     * @param resultCode  code for the second activity.
     * @param data        Intent data sent back from second activity.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // checking if the correct intent reply is made
        if (requestCode == TEXT_REQUEST) {
            // checking if the request was successful
            // RESULT_OK denotes successful request
            if (resultCode == RESULT_OK) {
                // fetching the intent extra from the response intent
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                // making the reply header visible
                mReplyHeadTextView.setVisibility(View.VISIBLE);

                // setting the reply and also making it visible
                mReplyTextView.setText(reply);
                // making the reply textView visible
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}