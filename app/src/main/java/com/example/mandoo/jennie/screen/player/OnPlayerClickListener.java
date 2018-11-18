package com.example.mandoo.jennie.screen.player;

import android.widget.SeekBar;

public interface OnPlayerClickListener {

    void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser);

    void onPlayClicked();

    void onNextClicked();

    void onPreviousClicked();

    void onLoopClicked();

    void onShuffleClicked();
}
