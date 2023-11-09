package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CheckSelect(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        if (view.getId() == R.id.c1) {
            if (checked) {
                Toast.makeText(MainActivity.this,
                        "English is Selected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,
                        "English is deselected", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.c2) {
            if (checked) {
                Toast.makeText(MainActivity.this,
                        "Malayalam is Selected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,
                        "Malayalam is deselected", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
