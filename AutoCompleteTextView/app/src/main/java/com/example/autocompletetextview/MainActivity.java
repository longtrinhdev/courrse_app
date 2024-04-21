package com.example.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoYourCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ id
        autoYourCountry = findViewById(R.id.autoYourCountry);
        //Khởi tạo mảng
        String[] arrCountries = getResources().getStringArray(R.array.countries_array);
        // Khởi tạo Adapter
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.custom_layout,R.id.txtRowCustom,arrCountries);
        // set adpater
        autoYourCountry.setAdapter(myAdapter);
    }
}