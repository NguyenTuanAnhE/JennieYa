package com.example.mandoo.jennie.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;

import com.example.mandoo.jennie.R;
import com.example.mandoo.jennie.databinding.ActivityMainBinding;
import com.example.mandoo.jennie.ui.base.BaseActivity;
import com.example.mandoo.jennie.ui.base.Navigator;

public class MainActivity extends BaseActivity {

    @Override
    protected boolean getFullScreen() {
        return true;
    }

    @Override
    protected void bindingContentView() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, getContentLayout());
        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.setNavigator(new Navigator(this));
        viewModel.getGenre();
    }

    @Override
    protected boolean showHomeEnable() {
        return false;
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected int getStatusBarColor() {
        return R.color.color_burnt_sienna;
    }

    @Override
    protected void initComponents() {

    }
}
