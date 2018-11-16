package com.example.mandoo.jennie.screen.player;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.SeekBar;

import com.example.mandoo.jennie.data.model.Song;
import com.example.mandoo.jennie.screen.base.Navigator;

public class PlayerViewModel extends AndroidViewModel implements SeekBar.OnSeekBarChangeListener {

    public ObservableField<Song> mSong;
    public ObservableField<Integer> mSongProgress;
    private Navigator mNavigator;
    private OnSeekBarChangeListener mListener;

    public PlayerViewModel(@NonNull Application application) {
        super(application);
        mSong = new ObservableField<>(new Song());
        mSongProgress = new ObservableField<>(0);
    }

    public void setNavigator(Navigator navigator) {
        mNavigator = navigator;
    }

    public void setListener(OnSeekBarChangeListener listener) {
        mListener = listener;
    }

    public void onProgressChanged(int progress) {
        mSongProgress.set(progress);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            mListener.onProgressChanged(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public interface OnSeekBarChangeListener {
        void onProgressChanged(int progress);
    }
}
