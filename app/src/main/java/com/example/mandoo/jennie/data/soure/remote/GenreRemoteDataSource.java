package com.example.mandoo.jennie.data.soure.remote;

import android.content.Context;

import com.example.mandoo.jennie.data.soure.GenreDataSource;

public class GenreRemoteDataSource implements GenreDataSource.Remote {

    private static GenreRemoteDataSource sGenreRemoteDataSource;

    public static void initContext() {
        if (sGenreRemoteDataSource == null) {
            sGenreRemoteDataSource = new GenreRemoteDataSource();
        }
    }

    public static GenreRemoteDataSource getInstance() {
        return sGenreRemoteDataSource;
    }

    @Override
    public void getRemoteGenre(GenreDataSource.OnFetchDataListener listener) {

    }
}
