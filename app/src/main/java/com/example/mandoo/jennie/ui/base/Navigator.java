package com.example.mandoo.jennie.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class Navigator {
    private Activity mActivity;

    public Navigator(Activity activity) {
        mActivity = activity;
    }

    public void startActivity(Intent intent) {
        mActivity.startActivity(intent);
    }

    public Context getContext() {
        return mActivity;
    }
}
