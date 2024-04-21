package com.example.recycleview;

public class OutData {
    private  int idImg;
    private  String tenPhim;
    private  String moTa;

    public  OutData() {}
    public  OutData(int idImg, String tenPhim, String moTa) {
        this.idImg = idImg;
        this.tenPhim = tenPhim;
        this.moTa = moTa;
    }
    // tạo getter và setter

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
