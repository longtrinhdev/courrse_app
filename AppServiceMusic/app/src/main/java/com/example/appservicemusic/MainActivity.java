package com.example.appservicemusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btnPlay,btnStop;
    Boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo Intent
                Intent myIntent1 = new Intent(MainActivity.this,MyService.class);
                // Khởi động Service
                startService(myIntent1);
                // Đảo hình ảnh
                if (flag == true) {
                    btnPlay.setImageResource(R.drawable.pause);
                    flag = false; // đảo cờ
                }else {
                    btnPlay.setImageResource(R.drawable.play);
                    flag = true;
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent2 = new Intent(MainActivity.this, MyService.class);
                // Gọi đến hàm dừng Service
                stopService(myIntent2);
                btnPlay.setImageResource(R.drawable.play);
                flag = true;
            }
        });
    }
}