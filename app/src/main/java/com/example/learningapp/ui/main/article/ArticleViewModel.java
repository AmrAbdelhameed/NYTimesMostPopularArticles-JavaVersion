package com.example.learningapp.ui.main.article;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.learningapp.data.DataManager;
import com.example.learningapp.data.model.api.Article;
import com.example.learningapp.ui.base.BaseViewModel;
import com.example.learningapp.utils.rx.SchedulerProvider;

import java.util.List;

public class ArticleViewModel extends BaseViewModel<ArticleNavigator> {

    private final MutableLiveData<List<Article>> articlesLiveData;

    public ArticleViewModel(DataManager dataManager,
                            SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        articlesLiveData = new MutableLiveData<>();
        fetchArticles();
    }

    public void fetchArticles() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getArticlesApiCall()
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

    public LiveData<List<Article>> getArticlesLiveDataLiveData() {
        return articlesLiveData;
    }
}
