package com.example.app1_xulysukientrenview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNhapA,edtNhapB, edtKQ;
    Button btnCong,btnReset;
    View suKienChiaSe = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNhapA = findViewById(R.id.edtNhapA);
        edtNhapB = findViewById(R.id.edtNhapB);
        edtKQ = findViewById(R.id.edtKQ);
        btnCong = findViewById(R.id.bntCong);
        btnReset = findViewById(R.id.btnReset);

        // set text cho edtNhapA
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String A = edtNhapA.getText().toString();
                String B = edtNhapB.getText().toString();
                int kq = Integer.parseInt(A) + Integer.parseInt(B);
                String KQ = String.valueOf(kq);
                edtKQ.setText(KQ);
            }
        });
        // Lắng nghe sự kiện trên Button Reset
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // xét chuỗi rỗng khi nhấn edtKQ
                edtNhapA.setText("");
                edtNhapB.setText("");
                edtKQ.setText("");

                // Thiết kế phần thông báo nhanh trên màn hình
                Toast.makeText(MainActivity.this,"Đã reset dữ liệu",Toast.LENGTH_SHORT).show();
            }
        });
        // 4. Tạo sự kiện chia sẻ: 1 biến có thể chia sẻ sự kiện cho >=2 view



    }
}