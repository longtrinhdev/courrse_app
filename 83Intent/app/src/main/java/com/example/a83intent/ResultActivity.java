package com.example.a83intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    EditText edtNhan;
    Button btnGoc,btnBP;
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        edtNhan = findViewById(R.id.edtNhanKQ);
        btnGoc = findViewById(R.id.btnGoc);
        btnBP = findViewById(R.id.btnBP);
        // Nhận Intent
        myIntent = getIntent();
        int a = myIntent.getIntExtra("soA",0);// giá trị mặc định nếu không có là bằng 0
        edtNhan.setText(a+"");
        btnGoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent.putExtra("kq",a);
                setResult(33,myIntent);
                finish();
            }
        });
        btnBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent.putExtra("kq",a*a);
                setResult(34,myIntent);
                finish();
            }
        });

    }
}