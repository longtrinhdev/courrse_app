package com.example.b8_giaiptb1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtNhapa, edtNhapb;
    Button btnKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // tham chiếu
        edtNhapa = findViewById(R.id.edtNhapa);
        edtNhapb = findViewById(R.id.edtNhapb);
        btnKQ = findViewById(R.id.btnKQ);
        // xử lý Click
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khai báo Intent
                Intent myIntent = new Intent(MainActivity.this,ActivityResult.class);
                // lấy dữ liệu
                int a = Integer.parseInt(edtNhapa.getText().toString());
                int b = Integer.parseInt(edtNhapb.getText().toString());
                // Đóng gói dữ liệu trước khi đưa vào Intent (đưa vào Bundle)
                // khai báo Bundle
                Bundle myBundle = new Bundle();
                myBundle.putInt("soA",a);
                myBundle.putInt("soB",b);
                // đưa bundle vào Intent
                myIntent.putExtra("myPackage",myBundle);
                // Khởi động Intent
                startActivity(myIntent);

            }
        });
    }
}