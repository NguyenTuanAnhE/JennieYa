package com.example.mandoo.jennie.service;

import com.example.mandoo.jennie.data.model.Song;

public interface PlayerController {

    void play(Song song);

    void playPause();

    void pause();

    void resume();

    void stop();

    void nextSong();

    void previousSong();

    void loop();

    void loopOne();

    void loopAll();

    void shuffle();

    void shuffleOn();

    void shuffleOff();

    Song getCurrentSong();

    int getCurrentProgress();

    void seekTo(int position);

}
