package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nytimesmostpopulararticles_mvvm.data.AppDataManager;
import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewModel;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;

import java.util.List;

public class ArticleViewModel extends BaseViewModel<ArticleNavigator> {

    private MutableLiveData<List<ArticlesResponse.Article>> articlesLiveData;

    public ArticleViewModel(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        super(application, appDataManager, schedulerProvider);
        articlesLiveData = new MutableLiveData<>();
        getArticles(7);
    }

    public void getArticles(int period) {
        setIsLoading(true);
        getCompositeDisposable().add(getAppDataManager().getApiRepository().getArticles(period)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(articlesResponse -> {
                    if (articlesResponse != null && articlesResponse.getArticles() != null) {
                        articlesLiveData.setValue(articlesResponse.getArticles());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public LiveData<List<ArticlesResponse.Article>> getArticlesLiveDataLiveData() {
        return articlesLiveData;
    }
}
