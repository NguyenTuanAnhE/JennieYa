package com.example.mandoo.jennie.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcelable;

import com.example.mandoo.jennie.data.model.Song;

import java.util.ArrayList;
import java.util.List;

public class PlayerService extends Service implements PlayerController, PlayerListener {

    private static final String ACTION_START_SERVICE = "com.example.mandoo.jennie.ACTION_START_SERVICE";
    private static final String ACTION_START_SONG = "com.example.mandoo.jennie.ACTION_START_SONG";
    private static final String EXTRA_LIST_SONG = "com.example.mandoo.jennie.EXTRA_LIST_SONG";
    private static final String EXTRA_PLAY_SONG = "com.example.mandoo.jennie.EXTRA_PLAY_SONG";

    private SongBinder mBinder = new SongBinder();
    private PlayerManager mManager;
    private List<PlayerListener> mListeners = new ArrayList<>();

    public static Intent getSongServiceIntent(Context context) {
        return new Intent(context, PlayerService.class);
    }

    public static Intent getSongServiceIntent(Context context, List<Song> songs) {
        Intent intent = new Intent(context, PlayerService.class);
        intent.setAction(ACTION_START_SERVICE);
        intent.putParcelableArrayListExtra(EXTRA_LIST_SONG, (ArrayList<? extends Parcelable>) songs);
        return intent;
    }

    public static Intent getSongServiceIntent(Context context, Song song) {
        Intent intent = new Intent(context, PlayerService.class);
        intent.setAction(ACTION_START_SONG);
        intent.putExtra(EXTRA_PLAY_SONG, song);
        return intent;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mManager = new PlayerManager();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null || intent.getAction() == null) return START_NOT_STICKY;
        switch (intent.getAction()) {
            case ACTION_START_SERVICE:
                List<Song> songs = intent.getParcelableArrayListExtra(EXTRA_LIST_SONG);
                mManager.setSongs(songs);
                break;
            case ACTION_START_SONG:
                Song song = intent.getParcelableExtra(EXTRA_PLAY_SONG);
                play(song);
                break;
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void play(Song song) {
        mManager.play(song);
    }

    @Override
    public void playPause() {
        mManager.playPause();
    }

    @Override
    public void pause() {
        mManager.pause();
    }

    @Override
    public void resume() {
        mManager.resume();
    }

    @Override
    public void stop() {
        mManager.stop();
    }

    @Override
    public void nextSong() {
        mManager.nextSong();
    }

    @Override
    public void previousSong() {
        mManager.previousSong();
    }

    @Override
    public void loop() {

    }

    @Override
    public void loopOne() {
        mManager.loopOne();
    }

    @Override
    public void loopAll() {
        mManager.loopAll();
    }

    @Override
    public void shuffle() {

    }

    @Override
    public void shuffleOn() {
        mManager.shuffleOn();
    }

    @Override
    public void shuffleOff() {
        mManager.shuffleOff();
    }

    @Override
    public Song getCurrentSong() {
        return mManager.getCurrentSong();
    }

    @Override
    public int getCurrentProgress() {
        return mManager.getCurrentProgress();
    }

    @Override
    public void seekTo(int position) {
        mManager.seekTo(position);
    }

    public void setListener(PlayerListener listener) {
        mListeners.add(listener);
    }

    public void removeListener(PlayerListener listener) {
        if (listener == null) return;
        mListeners.remove(listener);
    }

    @Override
    public void onChangePLayerState(int state) {
        for (PlayerListener listener : mListeners) {
            listener.onChangePLayerState(state);
        }
    }

    public class SongBinder extends Binder {

        public PlayerService getSongService() {
            return PlayerService.this;
        }

    }
}
