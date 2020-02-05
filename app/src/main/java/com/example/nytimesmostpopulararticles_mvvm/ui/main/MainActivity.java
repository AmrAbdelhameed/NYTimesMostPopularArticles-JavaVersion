package com.example.nytimesmostpopulararticles_mvvm.ui.main;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.example.nytimesmostpopulararticles_mvvm.BR;
import com.example.nytimesmostpopulararticles_mvvm.R;
import com.example.nytimesmostpopulararticles_mvvm.ViewModelProviderFactory;
import com.example.nytimesmostpopulararticles_mvvm.databinding.ActivityMainBinding;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>
        implements HasAndroidInjector {
    @Inject
    DispatchingAndroidInjector<Object> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProviderFactory factory;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return new ViewModelProvider(this, factory).get(MainViewModel.class);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
