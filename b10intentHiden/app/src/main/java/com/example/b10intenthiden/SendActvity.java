package com.example.b10intenthiden;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SendActvity extends AppCompatActivity {
    EditText edtSMS;
    ImageButton btnSMS;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_actvity);
        edtSMS = findViewById(R.id.edtSendSMS);
        btnSMS = findViewById(R.id.btnSMS);
        btnBack = findViewById(R.id.btnBack);

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo Intent ẩn
                // đối với hành động tin nhắn thì không yêu cầu sự động ý của người dùng
                Intent myIntentSMS = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+edtSMS.getText().toString()));
                startActivity(myIntentSMS);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}