package com.example.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // khai báo
    String myPhone[] = {"DT Samsung","DT Iphone","DT Oppo","DT Nokia","DT HP"};
    ArrayAdapter<String> myAdapter;
    ListView lvShow;
    TextView txtSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSelect = findViewById(R.id.txtSelect);
        lvShow = findViewById(R.id.lvShow);
        myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,myPhone);
        lvShow.setAdapter(myAdapter);
        // Bắt sự kiện click vào từng item của listview
        lvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtSelect.setText("Vị trí: " + position +" " +myPhone[position]);

            }
        });
    }
}