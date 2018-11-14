package com.example.mandoo.jennie.data.repository;

import com.example.mandoo.jennie.data.model.Song;
import com.example.mandoo.jennie.data.soure.SongDataSource;

public class SongRepository implements SongDataSource.Local {

    private static SongRepository sSongRepository;
    private SongDataSource.Local mLocal;

    public static SongRepository getInstance(SongDataSource.Local local) {
        if (sSongRepository == null) {
            sSongRepository = new SongRepository(local);
        }
        return sSongRepository;
    }

    private SongRepository(SongDataSource.Local local) {
        mLocal = local;
    }

    @Override
    public void getLocalSong(SongDataSource.OnGetLocalSongListener listener) {
        mLocal.getLocalSong(listener);
    }
}
