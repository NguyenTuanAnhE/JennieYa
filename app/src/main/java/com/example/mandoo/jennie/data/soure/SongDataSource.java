package com.example.mandoo.jennie.data.soure;

import com.example.mandoo.jennie.data.model.Song;

import java.util.List;

public interface SongDataSource {

    interface Local {

        void getLocalSong(OnGetLocalSongListener listener);
    }

    interface OnGetLocalSongListener {

        void onGetLocalSongSuccess(List<Song> songs);

        void onGetLocalSongFail();
    }
}
