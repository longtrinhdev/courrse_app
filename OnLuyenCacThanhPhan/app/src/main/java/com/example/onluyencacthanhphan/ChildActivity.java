package com.example.onluyencacthanhphan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {
    TextView txtShow;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        txtShow = findViewById(R.id.txtKQ);
        btnback = findViewById(R.id.btnBack);
        // Nhận Intent
        Intent myIntent = getIntent();
        // Lấy Bundle ra khỏi Intent
        Bundle myBundle = myIntent.getBundleExtra("package");
        // Lấy dữ liệu ra khỏi bundle
        int a = myBundle.getInt("soA");
        int b = myBundle.getInt("soB");
        String nghiem="";
        nghiem += a;
        nghiem += b;
        txtShow.setText(nghiem);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ngắt kết nối và quay về Activity ban đầu
                finish();
            }
        });
    }
}