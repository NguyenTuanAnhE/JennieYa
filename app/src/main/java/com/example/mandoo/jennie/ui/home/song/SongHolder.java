package com.example.mandoo.jennie.ui.home.song;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mandoo.jennie.data.model.Song;
import com.example.mandoo.jennie.databinding.ItemSongBinding;

class SongHolder extends RecyclerView.ViewHolder {

    private ItemSongBinding mBinding;
    private OnSongClickListener mListener;

    SongHolder(@NonNull View itemView, OnSongClickListener listener) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
        mListener = listener;
    }

    void bindData(Song song) {
        mBinding.setSong(song);
        mBinding.setListener(mListener);
    }
}
