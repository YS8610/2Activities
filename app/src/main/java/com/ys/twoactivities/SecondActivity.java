package com.ys.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private EditText mReply;
    private Button reply_button;
    public static final String EXTRA_REPLY= "com.example.android.twoactivities.extra.REPLY";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Log.d("secondActivity", message);

        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

        mReply = findViewById(R.id.editText_second);
        reply_button = findViewById(R.id.button_second);

        reply_button.setOnClickListener(view -> {
            String reply  = mReply.getText().toString();
            Intent intentReply = new Intent();
            intentReply.putExtra(EXTRA_REPLY,reply);
            setResult(RESULT_OK,intentReply);
            finish();

        });

    }
}