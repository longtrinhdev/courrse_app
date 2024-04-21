package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterRecycleView extends RecyclerView.Adapter<CustomAdapterRecycleView.FilmsViewHolder> {
    // Khai báo các thành phần
    private Context context;
    private ArrayList<OutData> lstFilms;

    // Khởi tạo Constructor

    public CustomAdapterRecycleView(Context context) {
        this.context = context;
    }
    // Viết hàm xét dữ liệu cho Adapter
    public void setData (ArrayList<OutData> list) {
        this.lstFilms = list;
        // gọi để Adapter load và bind dữ liệu vào Adapter
        notifyDataSetChanged();
    }
    // Tạo một ViewHolder mới
    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Chuyển đổi XML Layout sang dạng View
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        return new FilmsViewHolder(view);
    }
    // Xét dữ liệu load và bind dữ liệu
    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        OutData doiTuongMau = lstFilms.get(position);
        if(doiTuongMau == null) {
            return;
        }
        holder.imgHinhAnhMau.setImageResource(doiTuongMau.getIdImg());
        holder.txtTenPhimMau.setText(doiTuongMau.getTenPhim());
        holder.txtMoTaMau.setText(doiTuongMau.getMoTa());
    }
    // Số phần tử hiển thị trên View
    @Override
    public int getItemCount() {
        if (lstFilms != null) {
            return  lstFilms.size();
        }
        return 0;
    }

    // Xây dựng lớp ViewHolder
    // Xây dựng class FilmsViewHolder được sử dụng để hiển thị các thành phần  của một item trong RecycleView
    // lưu trữ tham chiếu đến các thành phần giao diện
    public  class FilmsViewHolder extends RecyclerView.ViewHolder {
        // Khai báo các thành phần trong RecyclerView
        private ImageView imgHinhAnhMau;
        private TextView txtTenPhimMau;
        private  TextView txtMoTaMau;

        // Khởi tạo constructor
        public FilmsViewHolder(@NonNull View itemView) {
            // Gọi constructor của lớp cơ sở RecyclerView.ViewHolder và truyền vào itemView đây là giao diện
            // của một item trong RecyclerView
            super(itemView);
            // Khai báo ánh xạ id
            imgHinhAnhMau = itemView.findViewById(R.id.imgHinhAnhMau);
            txtTenPhimMau = itemView.findViewById(R.id.txtTenPhimMau);
            txtMoTaMau = itemView.findViewById(R.id.txtMotaMau);

        }
    }
}
