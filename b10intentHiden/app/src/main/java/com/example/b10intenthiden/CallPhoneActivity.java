package com.example.b10intenthiden;




import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.core.app.ActivityCompat;

public class CallPhoneActivity extends AppCompatActivity {
    EditText edtCallPhone;
    ImageButton btnCallPhone;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);
        edtCallPhone = findViewById(R.id.edtCallPhone);
        btnCallPhone = findViewById(R.id.btnCall);
        btnBack = findViewById(R.id.btnBack);
        // xử lý click
        btnCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo Intent ẩn
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+edtCallPhone.getText().toString()));
                // Yêu cầu sự đồng ý của người dùng trước khi truy cập nhằm tăng bảo mật
                // Đoạn yêu cầu dưới đây được dùng cho mọi trường họp Intent ẩn
                if (ActivityCompat.checkSelfPermission(CallPhoneActivity.this,
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallPhoneActivity.this,new String[]{android.Manifest.permission.CALL_PHONE},1);
                    return;
                }
                startActivity(callIntent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}