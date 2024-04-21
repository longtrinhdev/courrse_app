package com.example.customspinner;

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

public class CustomAdapter extends ArrayAdapter<OutData> {
    public CustomAdapter(Context context, ArrayList<OutData> myList) {
        super(context,0,myList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    // gọi hàm getView để sắp xếp dữ liệu
    private View initView(int position,View convertView,ViewGroup parent) {
        if (convertView == null) {
            // Chuyển đổi layout từ xml sang 1 đối tượng View
            LayoutInflater myFlater = LayoutInflater.from(getContext());
            convertView = myFlater.inflate(R.layout.customspinner,parent,false);
//            convertView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.customspinner,parent,false
//            );
        }
        ImageView imgJuice = convertView.findViewById(R.id.imgOrange);
        TextView txtName = convertView.findViewById(R.id.txtShowJuice);

        OutData currentItem = getItem(position);
        if (currentItem != null) {
            imgJuice.setImageResource(currentItem.getId());
            txtName.setText(currentItem.getDes());
        }


        return  convertView;
    }
}
