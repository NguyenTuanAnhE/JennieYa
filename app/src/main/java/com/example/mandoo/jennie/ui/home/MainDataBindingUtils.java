package com.example.mandoo.jennie.ui.home;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

public class MainDataBindingUtils {

    @BindingAdapter("adapter")
    public static void setRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
