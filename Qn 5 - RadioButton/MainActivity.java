package com.example.radiobutton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
    }

    public void ButtonSelect(View view) {
        boolean selected = ((RadioButton) view).isChecked();

        android.util.Log.d("RadioButtonTest", "ButtonSelect called with ID: " + view.getId());

        if (view.getId() == R.id.ap) {
            if (selected) {
                output.setText("Visakhapatnam");
            }
        }
        else if (view.getId() == R.id.as) {
            if (selected) {
                output.setText("Dispur");
            }
        }
        else if (view.getId() == R.id.br) {
            if (selected) {
                output.setText("Patna");
            }
        }
        else if (view.getId() == R.id.gj) {
            if (selected) {
                output.setText("Gandhinagar");
            }
        }
        else if (view.getId() == R.id.ka) {
            if (selected) {
                output.setText("Bengaluru");
            }
        }
        else if (view.getId() == R.id.kl) {
            if (selected) {
                output.setText("Trivandrum");
            }
        }
        else if (view.getId() == R.id.mh) {
            if (selected) {
                output.setText("Mumbai");
            }
        }
        else if (view.getId() == R.id.pb) {
            if (selected) {
                output.setText("Chandigarh");
            }
        }
        else if (view.getId() == R.id.tn) {
            if (selected) {
                output.setText("Chennai");
            }
        }
        else if (view.getId() == R.id.up) {
            if (selected) {
                output.setText("Lucknow");
            }
        }
        else if (view.getId() == R.id.wb) {
            if (selected) {
                output.setText("Kolkata");
            }
        }
    }
}
