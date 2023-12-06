package com.example.qn4_checkboxcalculatesum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        CompoundButton.OnCheckedChangeListener {int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox cb1, cb2, cb3;
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b) {
            sum += Integer.valueOf(compoundButton.getText().toString());
        }
        else {
            sum -= Integer.valueOf(compoundButton.getText().toString());
        }
    }
    public void showSum(View view) {
        Toast.makeText(this, "Sum is " + sum, Toast.LENGTH_SHORT).show();
    }
}
