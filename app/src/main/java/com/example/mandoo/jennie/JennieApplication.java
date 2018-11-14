package com.example.mandoo.jennie;

import android.app.Application;

import com.example.mandoo.jennie.data.soure.local.GenreLocalDataSource;
import com.example.mandoo.jennie.data.soure.local.SongLocalDataSource;

public class JennieApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        GenreLocalDataSource.initContext(this);
        SongLocalDataSource.initContext(this);
    }
}
