package com.example.qn7_sharedprefsandintents;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button btnLogin;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btnLogin);
        preferences = getPreferences(MODE_PRIVATE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        // Check if the user is already logged in
        if (isLoggedIn()) {
            startHomeActivity();
        }
    }

    private void login() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Replace "admin" and "password" with your desired default values
        String defaultUsername = "admin";
        String defaultPassword = "password";

        if (username.equals(defaultUsername) && password.equals(defaultPassword)) {
            // Save login status to SharedPreferences
            saveLoginStatus(true);

            // Start HomeActivity
            startHomeActivity();
        } else {
            showToast("Invalid credentials");
        }
    }

    private void startHomeActivity() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish(); // finish the current activity
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private boolean isLoggedIn() {
        // Check the login status from SharedPreferences
        return preferences.getBoolean("isLoggedIn", false);
    }

    private void saveLoginStatus(boolean isLoggedIn) {
        // Save the login status to SharedPreferences
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLoggedIn", isLoggedIn);
        editor.apply();
    }
}
