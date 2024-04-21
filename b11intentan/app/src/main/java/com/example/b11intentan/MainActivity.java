package com.example.b11intentan;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgGirl;
    ImageButton btnCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgGirl = findViewById(R.id.imgGirl);
        btnCamera = findViewById(R.id.btnCamera);
        // xử lý click
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ACTION_IMAGE_CAPTURE);
                // Yêu cầu quyền truy cập
                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);
                    return;
                }
                startActivityForResult(myIntent,99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == Activity.RESULT_OK){// result là ứng dụng có sẵn nên mặc định
            // Lấy dữ liệu ra khỏi Intent và ép về kiểu Bitmap
            Bitmap photo = (Bitmap) data.getExtras().get("data");// key trong get là mặc định của Camera , mặc định là data
            // Hiển thị hình ảnh
            imgGirl.setImageBitmap(photo);
        }
    }
}