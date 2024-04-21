package com.example.grid_view;

// File OOP chứa các thuộc tính
public class OutData {
    private  int id;
    private  String tenTruyen;
    // Tạo constructor
    public  OutData(){}
    public OutData(int id, String tenTruyen) {
        this.id = id;
        this.tenTruyen = tenTruyen;
    }
    // Tạo Setter và getter
    public int getId() {
        return id;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }
    // Tạo toString()
    @Override
    public String toString() {
        return "OutData{" +
                "id=" + id +
                ", tenTruyen='" + tenTruyen + '\'' +
                '}';
    }
}
