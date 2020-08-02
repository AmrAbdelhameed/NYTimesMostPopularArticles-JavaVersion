package com.example.nytimesmostpopulararticles_mvvm.ui.base;

import android.app.Application;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

import com.example.nytimesmostpopulararticles_mvvm.data.AppDataManager;
import com.example.nytimesmostpopulararticles_mvvm.utils.SingleLiveEvent;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {
    private final Application application;
    private final AppDataManager mAppDataManager;
    private final SchedulerProvider mSchedulerProvider;
    private final ObservableBoolean mIsLoading = new ObservableBoolean();
    private SingleLiveEvent<String> showToast = new SingleLiveEvent<>();
    private CompositeDisposable mCompositeDisposable;

    public BaseViewModel(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        this.application = application;
        this.mAppDataManager = appDataManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public Application getApplication() {
        return application;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public AppDataManager getAppDataManager() {
        return mAppDataManager;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public SingleLiveEvent<String> getShowToast() {
        return showToast;
    }

    public void setShowToast(String message) {
        showToast.setValue(message);
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }
}
