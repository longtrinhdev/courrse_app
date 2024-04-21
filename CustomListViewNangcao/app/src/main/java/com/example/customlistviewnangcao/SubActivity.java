package com.example.customlistviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView txtShowPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        txtShowPhone = findViewById(R.id.txtShowPhone);
        // Nhận Intent
        Intent myIntent = getIntent();
        // lấy dữ liệu
        String namePhone = myIntent.getStringExtra("name");
        txtShowPhone.setText(namePhone);
    }
}