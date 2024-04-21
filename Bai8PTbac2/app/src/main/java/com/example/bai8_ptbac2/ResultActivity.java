package com.example.bai8_ptbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView txtShow;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtShow = findViewById(R.id.txtShow);
        btnBack = findViewById(R.id.btnBack);

        Intent myIntent = getIntent();
        Bundle myBundle = myIntent.getBundleExtra("myPackage");
        // lấy dữ liệu ở Bundle ra
        int a = myBundle.getInt("soA");
        int b = myBundle.getInt("soB");
        int c = myBundle.getInt("soC");

        // giải phương trình
        String nghiem ="";
        if (a == 0){
            if (b == 0){
                if (c==0){
                    nghiem = "PT vô số nghiệm";
                }else {
                     nghiem = "PT vô nghiệm";
                }
            }else {
                if (c==0){
                    nghiem = "Nghiệm: " + 0;
                }else {
                    nghiem = "Nghiệm: " + (-1.0)*c/b;
                }
            }
        }else {
            int delta = b*b - 4*a*c;
            if (delta <0) {
                nghiem = "PT vô nghiệm";
            }else if (delta == 0) {
                nghiem = "Nghiệm kép X1 = X2 = " + (-1.0)*b/2*a;
            }else {
                double x1 = (1.0)*(-b + Math.sqrt(delta))/2*a;
                double x2 = (1.0)*(-b - Math.sqrt(delta))/2*a;
                nghiem = "PT có 2 nghiệm PB:" + " X1= " + x1 + " X2= " + x2;
            }
        }
        txtShow.setText(nghiem);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}