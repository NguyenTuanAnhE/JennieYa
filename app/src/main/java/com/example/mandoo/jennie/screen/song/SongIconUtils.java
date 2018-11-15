package com.example.mandoo.jennie.screen.song;

import android.annotation.SuppressLint;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mandoo.jennie.R;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SongIconUtils {

    @BindingAdapter("songIcon")
    @SuppressLint("CheckResult")
    public static void setSongIcon(final ImageView imageView, String path) {

        Observable<Bitmap> bitmapObservable = Observable.just(getAlbumImage(imageView, path))
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());

        bitmapObservable.subscribe(new Consumer<Bitmap>() {
            @Override
            public void accept(Bitmap bitmap) throws Exception {
                Glide.with(imageView)
                        .load(bitmap)
                        .into(imageView);
            }
        });
    }

    private static Bitmap getAlbumImage(View view, String path) {

        if (path == null) {
            return BitmapFactory.decodeResource(view.getResources(), R.drawable.ic_play);
        }
        Uri uri = Uri.parse(path);
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        byte[] rawArt;

        BitmapFactory.Options bfo = new BitmapFactory.Options();

        mmr.setDataSource(view.getContext(), uri);
        rawArt = mmr.getEmbeddedPicture();

        if (null != rawArt) {
            return BitmapFactory.decodeByteArray(rawArt, 0, rawArt.length, bfo);
        }

        return BitmapFactory.decodeFile(path);
    }
}

