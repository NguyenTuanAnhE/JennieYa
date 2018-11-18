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
import static com.example.mandoo.jennie.util.media.SongState.PAUSED;
import static com.example.mandoo.jennie.util.media.SongState.PLAYING;

public class PlayerManager implements PlayerController, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private MediaPlayer mPlayer;
    private LoopStatus mLoop;
    private ShuffleStatus mShuffle;
    private List<Song> mSongs;
    private Song mCurrentSong;
    private Song mSelectedSong;
    private int mCurrentPosition;
    private int mState;
    private PlayerListener mListener;

    public PlayerManager() {
        mPlayer = new MediaPlayer();
        mLoop = new LoopStatus();
        mShuffle = new ShuffleStatus();
        mPlayer.setOnPreparedListener(this);
        mPlayer.setOnCompletionListener(this);
    }

    @Override
    public void play(Song song) {
        if (!isNewSongSelected(song)) return;
        if (mPlayer != null) mPlayer.reset();
        try {
            mSelectedSong = song;
            mPlayer.setDataSource(song.getUri());
            mPlayer.prepare();
        } catch (IOException e) {
            // TODO show error message
        }
    }

    @Override
    public void playPause() {
        if (mPlayer == null) return;
        if (mPlayer.isPlaying()) {
            pause();
            return;
        }
        resume();
    }

    @Override
    public void pause() {
        mPlayer.pause();
        mState = PAUSED;
        mListener.onChangePLayerState(mState);
    }

    @Override
    public void resume() {
        mPlayer.start();
        mState = PLAYING;
        mListener.onChangePLayerState(mState);
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
    public void loop() {

    }

    @Override
    public void loopOne() {
        mLoop.setLoop(LOOP_ONE);
        mState = LOOP_ONE;
        mListener.onChangePLayerState(mState);
    }

    @Override
    public void loopAll() {
        mLoop.setLoop(LOOP_ALL);
        mState = LOOP_ALL;
        mListener.onChangePLayerState(mState);
    }

    @Override
    public void shuffle() {
        mState = SHUFFLE_ON;
        mListener.onChangePLayerState(mState);
    }

    @Override
    public void shuffleOn() {
        mShuffle.setShuffle(SHUFFLE_ON);
        mState = SHUFFLE_ON;
        mListener.onChangePLayerState(mState);
    }

    @Override
    public void shuffleOff() {
        mShuffle.setShuffle(SHUFFLE_OFF);
        mState = SHUFFLE_OFF;
        mListener.onChangePLayerState(mState);
    }

    @Override
    public Song getCurrentSong() {
        return mCurrentSong;
    }

    @Override
    public int getCurrentProgress() {
        return mPlayer == null ? 0 : mPlayer.getCurrentPosition();
    }

    @Override
    public void seekTo(int position) {
        mPlayer.seekTo(position);
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

    private boolean isNewSongSelected(Song song) {
        return song != null && (mCurrentSong == null || song.getId() != mCurrentSong.getId());
    }

    private boolean isEndOfList() {
        return mCurrentPosition > mSongs.size() - 1;
    }

    public MediaPlayer getPlayer() {
        return mPlayer;
    }

    public void setPlayer(MediaPlayer player) {
        mPlayer = player;
    }

    public LoopStatus getLoop() {
        return mLoop;
    }

    public void setLoop(LoopStatus loop) {
        mLoop = loop;
    }

    public ShuffleStatus getShuffle() {
        return mShuffle;
    }

    public void setShuffle(ShuffleStatus shuffle) {
        mShuffle = shuffle;
    }

    public List<Song> getSongs() {
        return mSongs;
    }

    public void setSongs(List<Song> songs) {
        mSongs = songs;
    }

    public void setCurrentSong(Song currentSong) {
        mCurrentSong = currentSong;
    }

    public Song getSelectedSong() {
        return mSelectedSong;
    }

    public void setSelectedSong(Song selectedSong) {
        mSelectedSong = selectedSong;
    }

    public void setCurrentPosition(int currentPosition) {
        mCurrentPosition = currentPosition;
    }
}
