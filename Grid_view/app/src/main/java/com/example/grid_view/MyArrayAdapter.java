package com.example.grid_view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<OutData> {
    // Khai báo 3 tham số của Adapter
    Activity Context;// Khai báo Ac mà nó phục vụ
    int idLayout; // để định dạng và sắp xếp dữ liệu
    ArrayList<OutData> myList; // mảng dữ liệu
    // Tạo constructor để MainAc gọi đến
    public MyArrayAdapter(Activity Context, int idLayout, ArrayList<OutData> myList) {
        super(Context, idLayout,myList);
        this.Context = Context;
        this.idLayout = idLayout;
        this.myList = myList;
    }
    // Gọi hàm getView để lấy dữ liệu và sắp xếp hiển thị dữ liệu
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // tạo đế để chứa Layout
        LayoutInflater myFlater = Context.getLayoutInflater();
        // Đưa IDlayout vào đế để tạo View
        convertView = myFlater.inflate(idLayout,null);
        // Lấy 1 phần tử trong mảng dữ liệu
        OutData myItem = myList.get(position);
        // Khai báo , ánh xạ id và hiển thị ảnh
        ImageView imgItems = convertView.findViewById(R.id.imgItem);
        imgItems.setImageResource(myItem.getId());
        // Khai báo , ánh xạ id và hiển thị tên sản phẩm
        TextView txttenSanPham = convertView.findViewById(R.id.txtTenPhim);
        txttenSanPham.setText(myItem.getTenTruyen());
        return convertView;
    }


}
