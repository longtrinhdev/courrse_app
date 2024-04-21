package com.example.customspinner;

public class OutData {
    private int id;
    private String des;

    public OutData(int id, String des) {
        this.id = id;
        this.des = des;
    }
    public OutData(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
