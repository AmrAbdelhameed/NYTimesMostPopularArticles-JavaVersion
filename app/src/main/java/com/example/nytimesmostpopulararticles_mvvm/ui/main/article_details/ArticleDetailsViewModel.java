package com.example.nytimesmostpopulararticles_mvvm.ui.main.article_details;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nytimesmostpopulararticles_mvvm.data.AppDataManager;
import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewModel;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.article.ArticleDataItem;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;

public class ArticleDetailsViewModel extends BaseViewModel {
    private static final String TAG = "ArticleDetailsViewModel";
    private MutableLiveData<Boolean> isFavorite;

    public ArticleDetailsViewModel(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        super(application, appDataManager, schedulerProvider);
        isFavorite = new MutableLiveData<>();
    }

    public void insertArticle(ArticleDataItem articleDataItem) {
        getCompositeDisposable().add(getAppDataManager().getDbRepository().insertArticle(
                new Article(articleDataItem.getId()
                        , articleDataItem.getImageUrl()
                        , articleDataItem.getTitle()
                        , articleDataItem.getByline()
                        , articleDataItem.getAbstractX()
                        , articleDataItem.getPublishedDate()
                        , articleDataItem.getUrl()
                        , articleDataItem.getCoverImageUrl())
        )
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(b -> {
                    Log.d(TAG, "insertArticle: " + b);
                    isFavorite.setValue(true);
                }, throwable -> Log.d(TAG, "insertArticle: " + throwable.getMessage())));
    }

    public void deleteArticle(ArticleDataItem articleDataItem) {
        getCompositeDisposable().add(getAppDataManager().getDbRepository().deleteArticle(
                new Article(articleDataItem.getId()
                        , articleDataItem.getImageUrl()
                        , articleDataItem.getTitle()
                        , articleDataItem.getByline()
                        , articleDataItem.getAbstractX()
                        , articleDataItem.getPublishedDate()
                        , articleDataItem.getUrl()
                        , articleDataItem.getCoverImageUrl()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(b -> {
                    Log.d(TAG, "deleteArticle: " + b);
                    isFavorite.setValue(false);
                }, throwable -> Log.d(TAG, "deleteArticle: " + throwable.getMessage())));
    }

    public void findById(long id) {
        getCompositeDisposable().add(getAppDataManager().getDbRepository().findById(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(article -> {
                    Log.d(TAG, "findById: " + article.getId());
                    isFavorite.setValue(true);
                }, throwable -> {
                    Log.d(TAG, "findById: " + throwable.getMessage());
                    isFavorite.setValue(false);
                }));
    }

    public void onFavClick(boolean isFavorite, ArticleDataItem articleDataItem) {
        if (isFavorite)
            deleteArticle(articleDataItem);
        else
            insertArticle(articleDataItem);
    }

    public LiveData<Boolean> getIsFavorite() {
        return isFavorite;
    }
}
