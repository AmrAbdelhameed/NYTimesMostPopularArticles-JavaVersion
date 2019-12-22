package com.example.learningapp.ui.main.article;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.learningapp.data.DataManager;
import com.example.learningapp.data.model.api.ArticlesResponse;
import com.example.learningapp.ui.base.BaseViewModel;
import com.example.learningapp.utils.rx.SchedulerProvider;

import java.util.List;

public class ArticleViewModel extends BaseViewModel<ArticleNavigator> {

    private final MutableLiveData<List<ArticlesResponse.Article>> articlesLiveData;

    public ArticleViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        articlesLiveData = new MutableLiveData<>();
        fetchArticles(7);
    }

    public void fetchArticles(int period) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getArticlesApiCall(period)
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
