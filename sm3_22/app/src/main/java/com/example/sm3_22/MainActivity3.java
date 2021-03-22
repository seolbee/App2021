package com.example.sm3_22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{

    Button success;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        success = findViewById(R.id.baseSuccess);
        success.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast tost = Toast.makeText(this, "입력되었습니다.", Toast.LENGTH_SHORT);
        tost.show();
    }
}