package com.example.intent_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText;  // Renamed the class variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username);

        Button btn = findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
    }

    private void submit() {
        String enteredUsername = usernameEditText.getText().toString();  // Use a different name for the local variable

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("USERNAME", enteredUsername);  // Use the local variable here
        startActivity(intent);
    }
}
