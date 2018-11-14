package com.example.mandoo.jennie.ui.home.song;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import com.example.mandoo.jennie.R;
import com.example.mandoo.jennie.databinding.ActivitySongBinding;
import com.example.mandoo.jennie.ui.base.BaseActivity;
import com.example.mandoo.jennie.ui.base.Navigator;

public class SongActivity extends BaseActivity {

    public static Intent getSongActivityIntent(Context context) {
        return new Intent(context, SongActivity.class);
    }

    private SongViewModel mViewModel;

    @Override
    protected boolean getFullScreen() {
        return false;
    }

    @Override
    protected void bindingContentView() {
        ActivitySongBinding binding = DataBindingUtil.setContentView(this, getContentLayout());
        mViewModel = ViewModelProviders.of(this).get(SongViewModel.class);
        binding.setViewModel(mViewModel);
        mViewModel.setNavigator(new Navigator(this));

    }

    @Override
    protected boolean showHomeEnable() {
        return false;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_song;
    }

    @Override
    protected int getStatusBarColor() {
        return R.color.color_burnt_sienna;
    }

    @Override
    protected void initComponents() {
        requestPermission();
    }

    public void requestPermission() {
        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        } else {
            mViewModel.getLocalSong();
        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}
