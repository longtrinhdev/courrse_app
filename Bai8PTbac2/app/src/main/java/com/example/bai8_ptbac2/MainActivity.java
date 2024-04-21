package com.example.bai8_ptbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNhapa, edtNhapb, edtNhapc;
    Button btnKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNhapa = findViewById(R.id.edtNhapa);
        edtNhapb = findViewById(R.id.edtNhapb);
        edtNhapc = findViewById(R.id.edtNhapc);
        btnKQ = findViewById(R.id.btnKQ);

        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                int a = Integer.parseInt(edtNhapa.getText().toString());
                int b = Integer.parseInt(edtNhapb.getText().toString());
                int c = Integer.parseInt(edtNhapc.getText().toString());

                if ((a >'a' && a <'z') || (b >'a' && b <'z')||(c >'a' && c <'z')){
                    Toast.makeText(MainActivity.this,"Không nhập kí tự",Toast.LENGTH_SHORT).show();
                }else{
                    Bundle myBundle= new Bundle();
                    myBundle.putInt("soA",a);
                    myBundle.putInt("soB",b);
                    myBundle.putInt("soC",c);
                    myIntent.putExtra("myPackage",myBundle);
                    startActivity(myIntent);
                }
;
            }
        });

    }
}