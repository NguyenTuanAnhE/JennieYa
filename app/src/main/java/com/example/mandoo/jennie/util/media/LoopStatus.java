package com.example.mandoo.jennie.util.media;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.example.mandoo.jennie.util.media.LoopStatus.LoopValue.LOOP_ALL;
import static com.example.mandoo.jennie.util.media.LoopStatus.LoopValue.LOOP_NONE;
import static com.example.mandoo.jennie.util.media.LoopStatus.LoopValue.LOOP_ONE;

public class LoopStatus {
    private int loop;

    public int getLoop() {
        return loop;
    }

    public void setLoop(@LoopValue int loop) {
        this.loop = loop;
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            LOOP_NONE,
            LOOP_ONE,
            LOOP_ALL
    })
    public @interface LoopValue {
        int LOOP_NONE = 21;
        int LOOP_ONE = 8;
        int LOOP_ALL = 97;
    }
}
