package com.example.mandoo.jennie.ui.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mandoo.jennie.R;
import com.example.mandoo.jennie.data.model.Genre;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainHolder> {

    private List<Genre> mGenres;
    private LayoutInflater mInflater;
    private OnGenreClickListener mListener;

    MainAdapter(OnGenreClickListener listener) {
        mGenres = new ArrayList<>();
        mListener = listener;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new MainHolder(mInflater.inflate(R.layout.item_genre, viewGroup, false), mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder mainHolder, int i) {
        if (mGenres == null || mGenres.size() == 0) return;
        mainHolder.bindData(mGenres.get(i));
    }

    @Override
    public int getItemCount() {
        return mGenres == null ? 0 : mGenres.size();
    }

    public void setData(List<Genre> genres) {
        mGenres = genres;
        notifyDataSetChanged();
    }
}
