package com.example.mandoo.jennie.screen.song;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.example.mandoo.jennie.R;
import com.example.mandoo.jennie.data.model.Song;
import com.example.mandoo.jennie.data.repository.SongRepository;
import com.example.mandoo.jennie.data.soure.SongDataSource;
import com.example.mandoo.jennie.data.soure.local.SongLocalDataSource;
import com.example.mandoo.jennie.screen.base.Navigator;
import com.example.mandoo.jennie.screen.player.PlayerActivity;

import java.util.List;

public class SongViewModel extends AndroidViewModel implements OnSongClickListener, SongDataSource.OnGetLocalSongListener {

    public ObservableField<SongAdapter> mAdapter;
    public DividerItemDecoration mItemDecoration;
    private Navigator mNavigator;
    private SongRepository mSongRepository;

    public SongViewModel(@NonNull Application application) {
        super(application);
        mAdapter = new ObservableField<>(new SongAdapter(this));
        mSongRepository = SongRepository.getInstance(SongLocalDataSource.getInstance());
    }

    public void setNavigator(Navigator navigator) {
        mNavigator = navigator;
        mItemDecoration = new DividerItemDecoration(getApplication(),
                LinearLayoutManager.HORIZONTAL);
        mItemDecoration.setDrawable(mNavigator.getContext().getResources().getDrawable(R.drawable.recycler_devide));
    }

    void getLocalSong() {
        mSongRepository.getLocalSong(this);
    }

    @Override
    public void onSongClick(Song song) {
        mNavigator.startActivity(PlayerActivity.getPlayerActivityIntent(mNavigator.getContext(), song));
    }

    @Override
    public void onMenuClick(Song song) {

    }

    @Override
    public void onGetLocalSongSuccess(List<Song> songs) {
        mAdapter.get().setData(songs);
    }

    @Override
    public void onGetLocalSongFail() {

    }
}
