package com.example.mandoo.jennie.service;

import com.example.mandoo.jennie.data.model.Song;

public interface SongPlayerController {

    void play(Song song);

    void pause();

    void resume();

    void stop();

    void nextSong();

    void previousSong();

    void loopOne();

    void loopAll();

    void shuffleOn();

    void shuffleOff();

}
