package com.example.mandoo.jennie.ui.home;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mandoo.jennie.data.model.Genre;
import com.example.mandoo.jennie.databinding.ItemGenreBinding;
import com.example.mandoo.jennie.util.BindingUtils;

public class MainHolder extends RecyclerView.ViewHolder {

    private ItemGenreBinding mBinding;

    public MainHolder(@NonNull View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }

    public void bindData(Genre genre) {
        if (genre == null) return;
        mBinding.setGenre(genre);
    }
}
