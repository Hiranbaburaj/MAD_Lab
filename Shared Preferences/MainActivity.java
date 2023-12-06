package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.sharedpref", MODE_PRIVATE);
        sharedPreferences.edit().putString("username", "bob").apply();
        String username = sharedPreferences.getString("username", "not found");
        Log.d("My App", username);
    }
}