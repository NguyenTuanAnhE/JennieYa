package com.example.mandoo.jennie.screen.home;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mandoo.jennie.data.model.Genre;
import com.example.mandoo.jennie.databinding.ItemGenreBinding;

class MainHolder extends RecyclerView.ViewHolder {

    private ItemGenreBinding mBinding;
    private OnGenreClickListener mListener;

    MainHolder(@NonNull View itemView, OnGenreClickListener listener) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
        mListener = listener;
    }

    void bindData(Genre genre) {
        if (genre == null) return;
        mBinding.setGenre(genre);
        mBinding.setListener(mListener);
    }

}
