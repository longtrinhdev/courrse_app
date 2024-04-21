package com.example.receivesmsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        processSMS(context,intent);
    }

    private void processSMS(Context context, Intent intent) {
        Bundle myBundle = intent.getExtras();
        String message = "";
        String bodySMS = "";
        String phoneNumber = "";
        if (myBundle != null) {
            Object[] mySMS = (Object[])  myBundle.get("pdus");
            for (int i = 0; i< mySMS.length;i++) {
                 SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) mySMS[i]);
                 bodySMS += smsMessage.getMessageBody();
                 phoneNumber = smsMessage.getOriginatingAddress();
            }
            message = "Có 1 tin nhắn đến từ số điện thoại: " + phoneNumber + "\n"+bodySMS+" vừa gửi đến" +"\n";
            Toast.makeText(context,message,Toast.LENGTH_LONG);
        }
    }
}