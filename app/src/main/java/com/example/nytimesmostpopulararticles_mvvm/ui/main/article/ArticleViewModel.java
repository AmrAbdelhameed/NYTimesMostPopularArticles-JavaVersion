package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nytimesmostpopulararticles_mvvm.data.AppDataManager;
import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewModel;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

public class ArticleViewModel extends BaseViewModel {

    private MutableLiveData<List<ArticleDataItem>> articlesLiveData;

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
                        mapArticlesDataItem(articlesResponse.getArticles());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    setShowToast(throwable.getMessage());
                }));
    }

    public LiveData<List<ArticleDataItem>> getArticlesLiveData() {
        return articlesLiveData;
    }

    private void mapArticlesDataItem(List<ArticlesResponse.Article> articles) {
        List<ArticleDataItem> articleDataItems = new ArrayList<>();
        for (ArticlesResponse.Article article : articles) {
            articleDataItems.add(new ArticleDataItem(
                    article.getId()
                    , (article.getMedia() != null && article.getMedia().size() > 0) ? article.getMedia().get(0).getMediametadata().get(2).getUrl() : ""
                    , article.getTitle()
                    , article.getByline()
                    , article.getAbstractX()
                    , article.getPublished_date()
                    , article.getUrl(),
                    (article.getMedia() != null && article.getMedia().size() > 0) ? article.getMedia().get(0).getMediametadata().get(1).getUrl() : ""
            ));
        }
        articlesLiveData.setValue(articleDataItems);
    }
}
