package com.example.mandoo.jennie.data.soure.local;

import android.content.Context;
import android.content.res.Resources;

import com.example.mandoo.jennie.R;
import com.example.mandoo.jennie.data.model.Genre;
import com.example.mandoo.jennie.data.soure.GenreDataSource;

import java.util.ArrayList;
import java.util.List;

public class GenreLocalDataSource implements GenreDataSource.Local {

    private Context mContext;

    private static GenreLocalDataSource sGenreLocalDataSource;

    public static void initContext(Context context) {
        if (sGenreLocalDataSource == null) {
            sGenreLocalDataSource = new GenreLocalDataSource(context);
        }
    }

    public static GenreLocalDataSource getInstance() {
        return sGenreLocalDataSource;
    }

    private GenreLocalDataSource(Context context) {
        mContext = context;
    }

    @Override
    public void getLocalGenre(GenreDataSource.OnFetchDataListener listener) {
        List<Genre> genres = new ArrayList<>();
        Resources resources = mContext.getResources();
        genres.add(new Genre(resources.getString(R.string.my_music), "", R.drawable.home_cover_my_music));
        genres.add(new Genre(resources.getString(R.string.edit_video), "", R.drawable.home_cover_online_track));
        genres.add(new Genre(resources.getString(R.string.edit_audio), "", R.drawable.home_cover_audio));
        listener.onFetchDataSuccess(genres);
    }
}
