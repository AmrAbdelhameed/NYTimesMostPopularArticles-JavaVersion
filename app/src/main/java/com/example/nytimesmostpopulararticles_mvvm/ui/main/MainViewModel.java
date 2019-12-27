package com.example.nytimesmostpopulararticles_mvvm.ui.main;

import com.example.nytimesmostpopulararticles_mvvm.data.DataManager;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewModel;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel {

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
