package com.example.mandoo.jennie.screen.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mandoo.jennie.util.ColorUtils;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getFullScreen()) {
            ColorUtils.setFullScreen(this);
        }
        bindingContentView();
        ColorUtils.changeStatusBarColor(this, getStatusBarColor());
        initComponents();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeEnable());
            getSupportActionBar().setDisplayShowHomeEnabled(showHomeEnable());
        }
    }

    protected abstract boolean getFullScreen();

    protected abstract void bindingContentView();

    protected abstract boolean showHomeEnable();

    protected abstract int getContentLayout();

    protected abstract int getStatusBarColor();

    protected abstract void initComponents();
}
