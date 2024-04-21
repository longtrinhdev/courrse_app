package com.example.customlistviewnangcao;

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

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int idLayout;
    ArrayList<Phone> myList;
    // tạo Constructor
    public MyArrayAdapter(Activity context, int idLayout, ArrayList<Phone> myList) {
        super(context,idLayout,myList);
        this.context = context;
        this.idLayout = idLayout;
        this.myList = myList;
    }
    // gọi hàm getView để tiến hành sắp xếp dữ liệu

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Tạo đế chứa Layout
        LayoutInflater myFlater = context.getLayoutInflater();
        // đặt id layout lên đế để tạo thành 1 đối tượng view
        convertView = myFlater.inflate(idLayout,null);
        // Lấy 1 phần tử trong mảng
        Phone myPhone = myList.get(position);
        // Khai báo tham chiếu id và hiển thị lên ImageView
        ImageView imgPhone = convertView.findViewById(R.id.imgPhone);
        imgPhone.setImageResource(myPhone.getImage());
        // khai báo ,tham chiếu id và hiển thị tên điện thoại trên textView
        TextView txtPhone = convertView.findViewById(R.id.txtPhone);
        txtPhone.setText(myPhone.getName());
        return convertView;
    }
}
