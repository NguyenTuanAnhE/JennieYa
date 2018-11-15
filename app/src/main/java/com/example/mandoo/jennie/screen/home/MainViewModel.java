package com.example.mandoo.jennie.screen.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.example.mandoo.jennie.data.model.Genre;
import com.example.mandoo.jennie.data.repository.GenreRepository;
import com.example.mandoo.jennie.data.soure.GenreDataSource;
import com.example.mandoo.jennie.data.soure.local.GenreLocalDataSource;
import com.example.mandoo.jennie.data.soure.remote.GenreRemoteDataSource;
import com.example.mandoo.jennie.screen.base.Navigator;
import com.example.mandoo.jennie.screen.song.SongActivity;

import java.util.List;

public class MainViewModel extends AndroidViewModel implements GenreDataSource.OnFetchDataListener, OnGenreClickListener {
    public ObservableField<MainAdapter> mAdapter;
    private GenreRepository mGenreRepository;
    private Navigator mNavigator;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mAdapter = new ObservableField<>(new MainAdapter(this));
        mGenreRepository = GenreRepository.getInstance(GenreLocalDataSource.getInstance()
                , GenreRemoteDataSource.getInstance());
    }

    void setNavigator(Navigator navigator) {
        mNavigator = navigator;
    }

    void getGenre() {
        mGenreRepository.getLocalGenre(this);
    }

    @Override
    public void onFetchDataSuccess(List<Genre> genres) {
        mAdapter.get().setData(genres);
    }

    @Override
    public void onFetchDataFail() {

    }

    @Override
    public void onClick(Genre genre) {
        mNavigator.startActivity(SongActivity.getSongActivityIntent(mNavigator.getContext()));
    }
}
