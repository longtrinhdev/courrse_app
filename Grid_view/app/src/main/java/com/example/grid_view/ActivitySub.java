package com.example.grid_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivitySub extends AppCompatActivity {
    TextView txtSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        txtSub = findViewById(R.id.txtSub);
        // Nhận Intent
        Intent myIntent = getIntent();
        String name = myIntent.getStringExtra("name");
        txtSub.setText(name);
    }
}