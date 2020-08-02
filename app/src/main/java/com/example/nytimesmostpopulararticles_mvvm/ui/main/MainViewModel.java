package com.example.nytimesmostpopulararticles_mvvm.ui.main;

import android.app.Application;

import com.example.nytimesmostpopulararticles_mvvm.data.AppDataManager;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewModel;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel {
    public MainViewModel(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        super(application, appDataManager, schedulerProvider);
    }
}
