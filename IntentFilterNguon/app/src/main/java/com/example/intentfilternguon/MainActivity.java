package com.example.intentfilternguon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/*
* ----------------------------Mô tả ứng dụng---------------------------------------------
* Ứng dụng này sử dụng Intent ẩn để gọi đến trình duyệt web có sẵn trong máy có thể thực hiện chức
* năng mở link
* Ứng dụng này chỉ mở chứ không thu kết quả về nên ko cần startActivityForResult thay vào đó
* chúng ta sử dụng StartActivity() thôi.
* Chức năng: có thể mở trang đích từ một link nguồn.
* */

public class MainActivity extends AppCompatActivity {
    EditText edtInputLink;
    Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtInputLink = findViewById(R.id.edtInputLink);
        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo Intent ẩn
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+edtInputLink.getText().toString()));
                startActivity(myIntent);
            }
        });
    }
}