package com.example.mandoo.jennie.data.soure.local;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.mandoo.jennie.data.model.Song;
import com.example.mandoo.jennie.data.soure.SongDataSource;

import java.util.ArrayList;

public class SongIterator {

    private Context mContext;

    public SongIterator(Context context) {
        mContext = context;
    }

    public void getTracks(SongDataSource.OnGetLocalSongListener listener) {
        String[] projections = new String[]{
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ALBUM_ID,
        };

        Cursor cursor = mContext.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projections,
                null,
                null,
                MediaStore.Audio.Media.TITLE + " ASC"
        );

        ArrayList<Song> tracks = new ArrayList<>();

        if (cursor == null) {
            listener.onGetLocalSongFail();
        }
        if (cursor.getCount() == 0) {
            cursor.close();
            listener.onGetLocalSongFail();
        }

        int indexTitle = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
        int indexArtist = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
        int indexDuration = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
        int indexData = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);
        int indexAlbumId = cursor.getColumnIndex(MediaStore.Audio.Media._ID);
        int indexArtAlbum = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Song track = new Song();
            track.setTitle(cursor.getString(indexTitle));
            track.setUsername(cursor.getString(indexArtist));
            track.setDuration((int)cursor.getLong(indexDuration));
            track.setUri(cursor.getString(indexData));
            track.setId(cursor.getInt(indexAlbumId));

            Cursor artCursor = mContext.getContentResolver().query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                    new String[]{MediaStore.Audio.Albums._ID, MediaStore.Audio.Albums.ALBUM_ART},
                    MediaStore.Audio.Albums._ID + "=?",
                    new String[]{String.valueOf(cursor.getInt(indexArtAlbum))},
                    null);

            if (artCursor.moveToFirst()) {
                track.setAlbumArt(artCursor.getString(artCursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART)));
            }

            tracks.add(track);
            cursor.moveToNext();
        }
        cursor.close();
        listener.onGetLocalSongSuccess(tracks);

    }
}
