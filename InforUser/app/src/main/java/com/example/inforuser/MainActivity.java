package com.example.inforuser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.security.acl.Group;

public class MainActivity extends AppCompatActivity {
    EditText edtHoten, edtCMND,edtbosung;
    Button btnguithongtin;
    RadioGroup idgroup;
    CheckBox chkxemphim,chkchoigame,chkcoding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ id
        edtHoten = findViewById(R.id.edtHoten);
        edtCMND = findViewById(R.id.edtCMND);
        edtbosung = findViewById(R.id.edtbosung);
        btnguithongtin = findViewById(R.id.btnguithongtin);
        idgroup = findViewById(R.id.idgroup);
        chkxemphim = findViewById(R.id.chkxemphim);
        chkchoigame = findViewById(R.id.chkchoigame);
        chkcoding = findViewById(R.id.chkcoding);
        // Xử lý click vào Button
        btnguithongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                // lấy thông tin họ tên
                String hoTen = edtHoten.getText().toString();
                if (hoTen.length() <3) {
                    // nhận 3 giá trị là: tên activity, đoạn text, thời gian hiển thị(s-2s;l-3.5s)
                    Toast.makeText(MainActivity.this,"Họ tên không được nhỏ hơn 3 kí tự",Toast.LENGTH_SHORT).show();
                    edtHoten.requestFocus();// đưa con trỏ về ô nhập
                    edtHoten.selectAll();// bôi đen
                    return;// chờ người dùng nhập tiếp
                }
                // Lấy thông tin CMND
                String CMND = edtCMND.getText().toString();
                if (CMND.length() != 9) {
                    Toast.makeText(MainActivity.this,"CMND phải đủ 9 số",Toast.LENGTH_SHORT).show();
                    edtCMND.requestFocus();
                    edtCMND.selectAll();
                    return;
                }
                // Lấy thông tin bằng cấp
                int idSelect = idgroup.getCheckedRadioButtonId();// pthuc sẽ trả về id của Button được chọn trong group này
                RadioButton radSelect = findViewById(idSelect);// ánh xạ đến id đó
                String bangCap = radSelect.getText().toString();
                // Lấy thông tin sở thích
                String soThich = "";
                if (chkxemphim.isChecked()) {
                    soThich += chkxemphim.getText().toString() +" - ";
                }else if(chkchoigame.isChecked()){
                    soThich +=chkchoigame.getText().toString() + " - ";
                }else if(chkcoding.isChecked()){
                    soThich += chkcoding.getText().toString() ;
                }
                // Lấy thông tin bổ sung
                String boSung = edtbosung.getText().toString();
                String tongHop = hoTen +"\n" + CMND +"\n"+ bangCap +"\n"+soThich+"\n";
                tongHop = "------------THÔNG TIN BỔ SUNG------------\n";
                tongHop += boSung +"\n";
                tongHop+= "-----------------------------------------";
                // tạo dialog và hiển thị thông tin(tạo hộp thoại lên)
                AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
                myDialog.setTitle("THÔNG TIN CÁ NHÂN");
                myDialog.setMessage(tongHop);
                myDialog.setPositiveButton("ĐÓNG", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                myDialog.create();
            }
        });
    }
}