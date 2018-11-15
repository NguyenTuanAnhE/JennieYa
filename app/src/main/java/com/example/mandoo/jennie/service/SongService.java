package com.example.mandoo.jennie.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class SongService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public class SongBinder extends Binder {

        public SongService getSongService() {
            return SongService.this;
        }

    }
}
