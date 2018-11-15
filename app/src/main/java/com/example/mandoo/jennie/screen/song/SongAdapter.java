package com.example.mandoo.jennie.screen.song;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mandoo.jennie.R;
import com.example.mandoo.jennie.data.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongHolder> {

    private List<Song> mSongs;
    private LayoutInflater mInflater;
    private OnSongClickListener mListener;

    SongAdapter(OnSongClickListener listener) {
        mSongs = new ArrayList<>();
        mListener = listener;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new SongHolder(mInflater.inflate(R.layout.item_song, viewGroup, false), mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder songHolder, int i) {
        if (mSongs == null || mSongs.size() == 0) return;
        songHolder.bindData(mSongs.get(i));
    }

    @Override
    public int getItemCount() {
        return mSongs == null ? 0 : mSongs.size();
    }

    public void setData(List<Song> songs) {
        mSongs = songs;
        notifyDataSetChanged();
    }
}
