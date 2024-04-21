package com.example.grid_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Khai báo các mảng con
    int[] imagePicture = {R.drawable.banghoa,R.drawable.dauladailuc, R.drawable.dauphatk6,
            R.drawable.rong,R.drawable.thanlan, R.drawable.hoanhon};
    String[] tenFilms = {"Băng Hỏa Ma Trù","Đấu La Đại Lục","Đấu Phá Thương Khung","Gia Tộc Rồng","Thẩn Lan Chi Mộng","Hoàn Hồn"};
    // Khai báo GridView
    GridView gv;
    ArrayList<OutData> myList;
    MyArrayAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Thêm 3 mảng con vào mảng chính
        myList = new ArrayList<>();
        for(int i =0 ; i< tenFilms.length; i++) {
            myList.add(new OutData(imagePicture[i],tenFilms[i]));
        }
        myAdapter = new MyArrayAdapter(MainActivity.this,R.layout.layout_item,myList);
        gv = findViewById(R.id.gv);
        gv.setAdapter(myAdapter);
        // Xử lý sự kiện bấm vào item
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Khai báo intent
                Intent myIntent = new Intent(MainActivity.this, ActivitySub.class);
//                myIntent.putExtra("image",imagePicture[position]);
                myIntent.putExtra("name",tenFilms[position]);
                startActivity(myIntent);
            }
        });
    }
}