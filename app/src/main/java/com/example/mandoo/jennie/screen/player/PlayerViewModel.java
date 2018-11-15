package com.example.mandoo.jennie.screen.player;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.example.mandoo.jennie.data.model.Song;
import com.example.mandoo.jennie.screen.base.Navigator;

public class PlayerViewModel extends AndroidViewModel {

    public ObservableField<Song> mSong;
    private Navigator mNavigator;

    public PlayerViewModel(@NonNull Application application) {
        super(application);
        mSong = new ObservableField<>(new Song());
    }

    public void setNavigator(Navigator navigator) {
        mNavigator = navigator;
    }
}
