package com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.nytimesmostpopulararticles_mvvm.data.AppDataManager;
import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewModel;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;

import java.util.List;

public class FavoritesViewModel extends BaseViewModel<FavoritesNavigator> {
    private LiveData<List<Article>> articlesLiveData;

    public FavoritesViewModel(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        super(application, appDataManager, schedulerProvider);
        articlesLiveData = getAppDataManager().getDbRepository().getArticles();
    }

    public LiveData<List<Article>> getArticlesLiveDataLiveData() {
        return articlesLiveData;
    }
}
