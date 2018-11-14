package com.example.mandoo.jennie;

import android.app.Application;

import com.example.mandoo.jennie.data.soure.local.GenreLocalDataSource;

public class JennieApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        GenreLocalDataSource.initContext(this);
    }
}
