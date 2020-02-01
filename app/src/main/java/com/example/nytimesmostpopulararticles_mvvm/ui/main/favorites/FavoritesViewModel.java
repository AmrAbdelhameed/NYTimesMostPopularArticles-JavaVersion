package com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nytimesmostpopulararticles_mvvm.data.DataManager;
import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewModel;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;

import java.util.List;

public class FavoritesViewModel extends BaseViewModel<FavoritesNavigator> {
    private static final String TAG = "FavoritesViewModel";
    private final MutableLiveData<List<Article>> articlesLiveData = new MutableLiveData<>();

    public FavoritesViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        init();
    }

    public void init() {
        getAllArticle();
    }

    public void getAllArticle() {
        getCompositeDisposable().add(getDataManager()
                .getAllArticles()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(articles -> {
                    if (articles != null) {
                        articlesLiveData.setValue(articles);
                    }
                }, throwable -> {
                    Log.d(TAG, "getAllArticle: " + throwable.getMessage());
                }));
    }

    public LiveData<List<Article>> getArticlesLiveDataLiveData() {
        return articlesLiveData;
    }
}
