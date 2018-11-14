package com.example.mandoo.jennie.data.repository;

import com.example.mandoo.jennie.data.soure.GenreDataSource;

public class GenreRepository implements GenreDataSource.Local, GenreDataSource.Remote {

    private static GenreRepository sGenreRepository;
    private GenreDataSource.Local mLocal;

    public static GenreRepository getInstance(GenreDataSource.Local local, GenreDataSource.Remote remote) {
        if (sGenreRepository == null) {
            sGenreRepository = new GenreRepository(local, remote);
        }
        return sGenreRepository;
    }

    private GenreRepository(GenreDataSource.Local local, GenreDataSource.Remote remote) {
        mLocal = local;
    }

    @Override
    public void getLocalGenre(GenreDataSource.OnFetchDataListener listener) {
        mLocal.getLocalGenre(listener);
    }

    @Override
    public void getRemoteGenre(GenreDataSource.OnFetchDataListener listener) {

    }
}
