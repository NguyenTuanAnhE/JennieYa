package com.example.mandoo.jennie.util.media;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.example.mandoo.jennie.util.media.ShuffleStatus.ShuffleValue.SHUFFLE_OFF;
import static com.example.mandoo.jennie.util.media.ShuffleStatus.ShuffleValue.SHUFFLE_ON;

public class ShuffleStatus {
    private int mShuffle;

    public int getShuffle() {
        return mShuffle;
    }

    public void setShuffle(@ShuffleValue int shuffle) {
        mShuffle = shuffle;
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            SHUFFLE_ON,
            SHUFFLE_OFF
    })
    public @interface ShuffleValue {
        int SHUFFLE_ON = 1;
        int SHUFFLE_OFF = 2;
    }

}
