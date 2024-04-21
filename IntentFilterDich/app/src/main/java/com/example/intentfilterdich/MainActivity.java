package com.example.intentfilterdich;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

/*
* ---------------------------------------Mô tả ứng dụng-------------------------------------------
* - Ứng dụng sử dụng Intent Filter để thực hiện chức năng duyệt web , Intent Filter này sẽ thông báo
* cho hệ điều hành biết rằng cái ứng dụng này cũng có thể thực hiện chức năng duyệt web cùng với các
* úng dụng khác như chrome...
* Cần phải khai báo permission trong manifset để truy cập Internet
* */
public class MainActivity extends AppCompatActivity {
    WebView wvWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Khai báo nhận Intent
        wvWeb = findViewById(R.id.wvWeb);
        // Khai báo Intent
        Intent myIntent = getIntent();
        // Nhận dữ liệu từ Intent và kiểu của nó là Uri
        Uri myLink = myIntent.getData(); // nhận data
        try {
            // đưa đường link lên webview: loadUrl chỉ nhận kiểu string
            wvWeb.loadUrl(myLink.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}