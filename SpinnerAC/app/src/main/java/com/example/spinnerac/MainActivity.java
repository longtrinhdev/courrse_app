package com.example.spinnerac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spMonHoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // gọi hàm trong file chính
//        setupFunctionSpinner();
        setupFunctionNotStringXMLSpinner();
    }



    // Hàm cố định tác động vào file String.xml
//    private void setupFunctionSpinner() {
//        // tham chiếu id
//        spMonHoc = findViewById(R.id.spMonHoc);
//        // tạo một list chứa môn học- lấy từ file string.xml
//        String[] arr = getResources().getStringArray(R.array.monhoc);
//        // khởi tạo Adapter với mảng chuỗi
//        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,arr);
//        // Đặt kiểu layout cho spinner cơ bản
//        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Thiết lập Adapter cho spinner
//        spMonHoc.setAdapter(myAdapter);
//    }
    // Hàm với nguồn cấp là một list có thể thay đổi được(ko tác động vào String.xml nữa)
    private void setupFunctionNotStringXMLSpinner() {
        // Tham chiếu id
        spMonHoc = findViewById(R.id.spMonHoc);
        // Tạo list chứa các môn học
        ArrayList<String> arrMonHoc = new ArrayList<String>();
        // Thêm các môn học vào list
        arrMonHoc.add("Toán");
        arrMonHoc.add("Văn");
        arrMonHoc.add("Anh");
        arrMonHoc.add("Lịch Sử");
        arrMonHoc.add("Khoa học");
        // Khởi tạo adapter với mảng dữ liệu
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,arrMonHoc);
        // Thiết lập Adapter cho spinner
        spMonHoc.setAdapter(myAdapter);
        // Bắt sự kiện click
        spMonHoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // Hàm dùng khi item được click
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Bạn đã chọn " + arrMonHoc.get(position),Toast.LENGTH_LONG).show();
            }
            // Hàm dùng khi Item ko được click
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}