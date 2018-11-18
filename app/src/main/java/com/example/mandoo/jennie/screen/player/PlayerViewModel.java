package com.example.mandoo.jennie.screen.player;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.widget.SeekBar;

import com.example.mandoo.jennie.data.model.Song;
import com.example.mandoo.jennie.screen.base.Navigator;

public class PlayerViewModel extends AndroidViewModel {

    public ObservableField<Song> mSong;
    public ObservableField<Integer> mSongProgress;
    private Navigator mNavigator;
    private OnSongChangeListener mListener;

    public PlayerViewModel(@NonNull Application application) {
        super(application);
        mSong = new ObservableField<>(new Song());
        mSongProgress = new ObservableField<>(0);
    }

    public void setNavigator(Navigator navigator) {
        mNavigator = navigator;
    }

    public void setListener(OnSongChangeListener listener) {
        mListener = listener;
    }

    public void onProgressChanged(int progress) {
        mSongProgress.set(progress);
    }

    public interface OnSongChangeListener {


    }
}
