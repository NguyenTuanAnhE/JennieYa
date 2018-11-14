package com.example.mandoo.jennie.util;

import android.databinding.BindingAdapter;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BindingUtils {

    @BindingAdapter("adapter")
    public static void setRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView view, String url) {
        Glide.with(view).load(url).into(view);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView view, int id) {
        Glide.with(view).load(id).into(view);
    }

    @BindingAdapter("itemDecoration")
    public static void setItemDecoration(RecyclerView recyclerView, DividerItemDecoration decoration) {
        recyclerView.addItemDecoration(decoration);
    }


}
