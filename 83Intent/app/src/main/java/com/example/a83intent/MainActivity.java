package com.example.a83intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtA,edtKQ;
    Button btnRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtA = findViewById(R.id.edtA);
        edtKQ = findViewById(R.id.edtKQ);
        btnRequest = findViewById(R.id.btnRequest);
        // xử lý click
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                int a = Integer.parseInt(edtA.getText().toString());
                myIntent.putExtra("soA",a);
                startActivityForResult(myIntent,99);

            }
        });
    }
    // Hàm nhận KQ

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==99 && resultCode==33){
            int kq = data.getIntExtra("kq",0);
            edtKQ.setText("Giá trị gốc là: "+kq);
        }
        if (requestCode==99 && resultCode== 34) {
            int kq = data.getIntExtra("kq",0);
            edtKQ.setText("Giá trị BP là: " + kq);
        }
    }
}