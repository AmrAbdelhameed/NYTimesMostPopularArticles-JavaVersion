package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nytimesmostpopulararticles_mvvm.data.AppDataManager;
import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewModel;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;

import java.util.List;

public class ArticleViewModel extends BaseViewModel<ArticleNavigator> {

    private MutableLiveData<List<ArticlesResponse.Article>> articlesLiveData;

    public ArticleViewModel(AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        super(appDataManager, schedulerProvider);
        articlesLiveData = new MutableLiveData<>();
        fetchArticles(7);
    }

    public void fetchArticles(int period) {
        setIsLoading(true);
        getCompositeDisposable().add(getAppDataManager().getAppApiHelper().getArticles(period)
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
