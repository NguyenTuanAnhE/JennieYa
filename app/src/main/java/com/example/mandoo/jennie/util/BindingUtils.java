package com.example.mandoo.jennie.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BindingUtils {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView view, String url) {
        Glide.with(view).load(url).into(view);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView view, int id) {
        Glide.with(view).load(id).into(view);
    }
}
