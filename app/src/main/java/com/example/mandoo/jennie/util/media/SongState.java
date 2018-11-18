package com.example.mandoo.jennie.util.media;

import android.support.annotation.IntDef;

import static com.example.mandoo.jennie.util.media.SongState.ERROR;
import static com.example.mandoo.jennie.util.media.SongState.IDLE;
import static com.example.mandoo.jennie.util.media.SongState.PAUSED;
import static com.example.mandoo.jennie.util.media.SongState.PLAYING;
import static com.example.mandoo.jennie.util.media.SongState.PREPARED;
import static com.example.mandoo.jennie.util.media.SongState.PREPARING;
import static com.example.mandoo.jennie.util.media.SongState.STOPPED;

@IntDef({IDLE, PLAYING, PREPARING, PREPARED, PAUSED, STOPPED, ERROR})
public @interface SongState {

    int IDLE = 0;
    int PLAYING = 1;
    int PREPARED = 2;
    int PREPARING = 3;
    int PAUSED = 4;
    int STOPPED = 5;
    int ERROR = 6;
}
