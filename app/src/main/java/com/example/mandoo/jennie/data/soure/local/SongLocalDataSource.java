package com.example.mandoo.jennie.data.soure.local;

import android.content.Context;

import com.example.mandoo.jennie.data.soure.SongDataSource;

public class SongLocalDataSource implements SongDataSource.Local {

    private static SongLocalDataSource sSongLocalDataSource;
    private SongIterator mIterator;

    public static SongLocalDataSource getInstance() {
        return sSongLocalDataSource;
    }

    public static void initContext(Context context) {
        if (sSongLocalDataSource == null) {
            sSongLocalDataSource = new SongLocalDataSource(context);
        }
    }

    private SongLocalDataSource(Context context) {
        mIterator = new SongIterator(context);
    }

    @Override
    public void getLocalSong(SongDataSource.OnGetLocalSongListener listener) {
        mIterator.getTracks(listener);
    }
}
