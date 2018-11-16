package com.example.mandoo.jennie.screen.player;

import android.arch.lifecycle.ViewModelProviders;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.IBinder;

import com.example.mandoo.jennie.R;
import com.example.mandoo.jennie.databinding.ActivityPlayerBinding;
import com.example.mandoo.jennie.screen.base.BaseActivity;
import com.example.mandoo.jennie.screen.base.Navigator;
import com.example.mandoo.jennie.service.SongService;

public class PlayerActivity extends BaseActivity implements PlayerViewModel.OnSeekBarChangeListener {

    private static final int DELAY_TIME = 200;

    private SongService mService;
    private PlayerViewModel mViewModel;
    private boolean mIsBound;
    private Handler mHandler;

    public static Intent getPlayerActivityIntent(Context context) {
        return new Intent(context, PlayerActivity.class);
    }

    @Override
    protected boolean getFullScreen() {
        return false;
    }

    @Override
    protected void bindingContentView() {
        ActivityPlayerBinding binding = DataBindingUtil.setContentView(this, getContentLayout());
        mViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        mViewModel.setNavigator(new Navigator(this));
        mViewModel.setListener(this);
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
        mHandler = new Handler();
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            SongService.SongBinder binder = (SongService.SongBinder) service;
            mService = binder.getSongService();
            mIsBound = true;

            mViewModel.mSong.set(mService.getCurrentSong());
            getSongProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIsBound = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        bindService(SongService.getSongServiceIntent(this), mConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mIsBound) {
            unbindService(mConnection);
            mIsBound = false;
        }
    }

    public void getSongProgress() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewModel.mSongProgress.set(mService.getCurrentProgress());
                mHandler.postDelayed(this, DELAY_TIME);
            }
        }, 0);
    }

    @Override
    public void onProgressChanged(int progress) {

    }
}
