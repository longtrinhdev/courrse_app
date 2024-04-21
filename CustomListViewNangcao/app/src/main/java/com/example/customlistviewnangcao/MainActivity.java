package com.example.customlistviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int[] image = {R.drawable.samsung,R.drawable.ip,R.drawable.htc,R.drawable.wp,R.drawable.lg,R.drawable.sky};
    String[] name = {"DT samsung","DT Iphone","DT HTC","DT Window phone","DT LG","DT Sky"};
    // Khai báo ListView
    ArrayList<Phone> myList;
    MyArrayAdapter myAdapter;
    ListView lvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvShow = findViewById(R.id.lvShow);
        myList = new ArrayList<>();
        for (int i =0;i<name.length;i++){
            myList.add(new Phone(image[i],name[i]));
        }
        myAdapter = new MyArrayAdapter(MainActivity.this,R.layout.layout_item,myList);
        lvShow.setAdapter(myAdapter);
        // xử lý click
        lvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this,SubActivity.class);
                myIntent.putExtra("name",name[position]);
                startActivity(myIntent);
            }
        });
    }
}