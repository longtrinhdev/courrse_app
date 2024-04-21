package com.example.appservicemusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    // Khai báo đối tượng mà Service quản lý
    MediaPlayer myMusic;
    @Override
    // hàm dùng để trao đổi giữa Service và Ac
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    // Do trong bài này chúng ta chạy xuyên suốt không cần trao đổi dữ liệu nên k cần sử dụng hàm trên.

    // Hàm khởi tạo đối tượng mà Service quản lý
    @Override
    public void onCreate() {
        super.onCreate();
        myMusic = MediaPlayer.create(MyService.this, R.raw.thuantheoytroi);
        myMusic.setLooping(true); // lặp đi lặp lại bài hát
    }
    // Hàm khởi động Service

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (myMusic.isPlaying()) {
            myMusic.pause();
        }
        else
        {
            myMusic.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }
    // Hàm dùng để dừng đối tượng mà Service quản lý

    @Override
    public void onDestroy() {
        super.onDestroy();
        myMusic.stop();
    }
}