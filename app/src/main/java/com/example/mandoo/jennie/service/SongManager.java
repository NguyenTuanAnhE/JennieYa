package com.example.mandoo.jennie.service;

import android.media.MediaPlayer;

import com.example.mandoo.jennie.data.model.Song;
import com.example.mandoo.jennie.util.media.LoopStatus;
import com.example.mandoo.jennie.util.media.ShuffleStatus;

import java.io.IOException;
import java.util.List;

import static com.example.mandoo.jennie.util.media.LoopStatus.LoopValue.LOOP_ALL;
import static com.example.mandoo.jennie.util.media.LoopStatus.LoopValue.LOOP_ONE;
import static com.example.mandoo.jennie.util.media.ShuffleStatus.ShuffleValue.SHUFFLE_OFF;
import static com.example.mandoo.jennie.util.media.ShuffleStatus.ShuffleValue.SHUFFLE_ON;

public class SongManager implements SongPlayerController, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private MediaPlayer mPlayer;
    private LoopStatus mLoop;
    private ShuffleStatus mShuffle;
    private List<Song> mSongs;
    private Song mCurrentSong;
    private Song mSelectedSong;
    private int mCurrentPosition;

    public SongManager() {
        mPlayer = new MediaPlayer();
        mLoop = new LoopStatus();
        mShuffle = new ShuffleStatus();
        mPlayer.setOnPreparedListener(this);
        mPlayer.setOnCompletionListener(this);
    }

    @Override
    public void play(Song song) {
        if (song.getId() == mCurrentSong.getId()) return;
        try {
            mSelectedSong = song;
            mPlayer.setDataSource(song.getUri());
            mPlayer.prepare();
        } catch (IOException e) {
            // TODO show error message
        }
    }

    @Override
    public void pause() {
        if (mPlayer.isPlaying()) mPlayer.pause();
    }

    @Override
    public void resume() {
        if (!mPlayer.isPlaying()) mPlayer.start();
    }

    @Override
    public void stop() {

    }

    @Override
    public void nextSong() {
        if (isEndOfList()) {
            if (mLoop.getLoop() != LOOP_ALL) return;
            mCurrentPosition = -1;
        }
        mCurrentPosition++;
        play(mSongs.get(mCurrentPosition));
    }

    @Override
    public void previousSong() {
        if (mCurrentPosition == 0) return;
        mCurrentPosition--;
        play(mSongs.get(mCurrentPosition));
    }

    @Override
    public void loopOne() {
        mLoop.setLoop(LOOP_ONE);
    }

    @Override
    public void loopAll() {
        mLoop.setLoop(LOOP_ALL);
    }

    @Override
    public void shuffleOn() {
        mShuffle.setShuffle(SHUFFLE_ON);
    }

    @Override
    public void shuffleOff() {
        mShuffle.setShuffle(SHUFFLE_OFF);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mCurrentSong = mSelectedSong;
        mp.start();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        switch (mLoop.getLoop()) {
            case LOOP_ONE:
                play(mCurrentSong);
                break;
            default:
                nextSong();
                break;
        }
    }

    private boolean isEndOfList() {
        return mCurrentPosition > mSongs.size() - 1;
    }
}
