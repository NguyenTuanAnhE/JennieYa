package com.example.mandoo.jennie.util;

import android.databinding.BindingAdapter;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

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

    @BindingAdapter("setDuration")
    public static void setDuration(TextView view, int progress) {
        view.setText(DurationUtils.getDuration(progress));
    }

    @BindingAdapter("setMax")
    public static void setMax(SeekBar seekBar, int progress) {
        seekBar.setMax(progress);
    }

    @BindingAdapter("onSeekBarChangeListener")
    public static void setOnSeekBarChangeListener(SeekBar seekBar, SeekBar.OnSeekBarChangeListener listener) {
        seekBar.setOnSeekBarChangeListener(listener);
    }
}
