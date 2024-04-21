package com.example.customspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<OutData> myJuiceList;
    private Spinner spJuice;
    private CustomAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hàm tạo danh sách
        initList();
        // Ánh xạ id Spinner
        spJuice = findViewById(R.id.spLoaiQua);
        myAdapter = new CustomAdapter(this,myJuiceList);
        spJuice.setAdapter(myAdapter);

        spJuice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                OutData clickeditem = (OutData) parent.getItemAtPosition(position);
                String clickedJuiceName = clickeditem.getDes();
//                Toast.makeText(MainActivity.this,"Bạn đã chọn " + clickedJuiceName,Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"Bạn đã chọn " + myAdapter.getItem(position).getDes(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initList() {
        myJuiceList = new ArrayList<>();
        myJuiceList.add(new OutData(R.drawable.cam,"Quả Cam"));
        myJuiceList.add(new OutData(R.drawable.duahau,"Quả Dưa Hấu"));
        myJuiceList.add(new OutData(R.drawable.tao,"Quả Táo"));
        myJuiceList.add(new OutData(R.drawable.xoai,"Quả Xoài"));
        myJuiceList.add(new OutData(R.drawable.sauchung,"Quả Sầu Riêng"));

    }
}