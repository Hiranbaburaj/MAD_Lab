package com.example.qn7_sharedprefsandintents;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("creds", MODE_PRIVATE);
        String userName = preferences.getString("userName", "");
        if(userName.equals("")) {
            startActivity(new Intent(this, LoginScreen.class));
        }
        ((TextView)findViewById(R.id.userNameDisplay)).setText("Logged in as:"+
                userName);
    }
    public void logout(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userName", "");
        editor.apply();
        startActivity(new Intent(this, LoginScreen.class));
    }
}