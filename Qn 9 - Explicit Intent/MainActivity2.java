package com.example.intent_test;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView resultTextView = findViewById(R.id.result);

        // Retrieve data from Intent
        String username = getIntent().getStringExtra("USERNAME");
        resultTextView.setText(username);
    }
}
