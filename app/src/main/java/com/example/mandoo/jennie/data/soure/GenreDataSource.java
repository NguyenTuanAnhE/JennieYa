package com.example.mandoo.jennie.data.soure;

import com.example.mandoo.jennie.data.model.Genre;

import java.util.List;

public interface GenreDataSource {

    interface Local {
        void getLocalGenre(OnFetchDataListener listener);
    }

    interface Remote {
        void getRemoteGenre(OnFetchDataListener listener);
    }

    interface OnFetchDataListener {
        void onFetchDataSuccess(List<Genre> genres);

        void onFetchDataFail();
    }
}
