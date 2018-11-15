package com.example.mandoo.jennie.screen.player;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;

import com.example.mandoo.jennie.R;
import com.example.mandoo.jennie.data.model.Song;
import com.example.mandoo.jennie.databinding.ActivityPlayerBinding;
import com.example.mandoo.jennie.screen.base.BaseActivity;
import com.example.mandoo.jennie.screen.base.Navigator;

public class PlayerActivity extends BaseActivity {

    private static final String EXTRA_SONG = "com.example.mandoo.jennie.EXTRA_SONG";

    private PlayerViewModel mViewModel;

    public static Intent getPlayerActivityIntent(Context context, Song song) {
        Intent intent = new Intent(context, PlayerActivity.class);
        intent.putExtra(EXTRA_SONG, song);
        return intent;
    }

    @Override
    protected boolean getFullScreen() {
        return false;
    }

    @Override
    protected void bindingContentView() {
        ActivityPlayerBinding binding = DataBindingUtil.setContentView(this, getContentLayout());
        mViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);

        Song song = getIntent().getParcelableExtra(EXTRA_SONG);
        mViewModel.mSong.set(song);
        mViewModel.setNavigator(new Navigator(this));
        binding.setViewModel(mViewModel);
    }

    @Override
    protected boolean showHomeEnable() {
        return false;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_player;
    }

    @Override
    protected int getStatusBarColor() {
        return R.color.color_burnt_sienna;
    }

    @Override
    protected void initComponents() {

    }
}
