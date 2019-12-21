package com.example.learningapp.ui.main;

import com.example.learningapp.data.DataManager;
import com.example.learningapp.ui.base.BaseViewModel;
import com.example.learningapp.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel {

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
