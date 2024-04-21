package com.example.b8_giaiptb1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {
    TextView txtKQ;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtKQ = findViewById(R.id.txtKQ);
        btnBack = findViewById(R.id.btnBack);
        // Nhận Intent
        Intent myIntent = getIntent();
        // Lấy Bundle ra khỏi Intent
        Bundle myBundle = myIntent.getBundleExtra("myPackage");
        // Lấy dữ liệu ở Bundle
        int a = myBundle.getInt("soA");
        int b = myBundle.getInt("soB");
        // giải phương trình
        String nghiem="";
        if (a == 0 && b==0){
            nghiem = "PT vô số nghiệm";
        }else if (a == 0 && b !=0){
            nghiem ="PT Vô nghiệm!";
        }else {
            nghiem = "Nghiệm:" + ((-1.0)*b /a);
        }
        txtKQ.setText(nghiem);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}