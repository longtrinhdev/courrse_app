package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Khai báo List và các mảng dữ liệu
    int[] imgHinhAnhFilm = {R.drawable.banghoa,R.drawable.hoanhon, R.drawable.rong,R.drawable.thanlan};
    String[] tenPhimBo = {"Băng Hỏa","Hoàn Hồn","Gia Tộc Rồng","Thần Long"};
    String[] moTaPhim = {"Phim Trung Quốc","Phim Hàn Quốc","Phim Châu Âu","Phim Trung Quốc"};
    // Khai báo các thành phần
    private RecyclerView rvPhimBo;
    private  CustomAdapterRecycleView myAdapterFilms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPhimBo = findViewById(R.id.rvPhimBo);
        myAdapterFilms = new CustomAdapterRecycleView(MainActivity.this);

        // Khai báo layout hiển thị
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL,false);
        rvPhimBo.setLayoutManager(linearLayoutManager);
        // xét dữ liệu cho Adapter
        myAdapterFilms.setData(getListFilms());
        // xét Adapter
        rvPhimBo.setAdapter(myAdapterFilms);
    }
    private ArrayList<OutData> getListFilms() {
        ArrayList<OutData> lstList = new ArrayList<>();
        for(int i =0 ; i< tenPhimBo.length;i++) {
            lstList.add(new OutData(imgHinhAnhFilm[i],tenPhimBo[i],moTaPhim[i]));
        }
        return lstList;
    }
}