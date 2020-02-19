package com.example.nytimesmostpopulararticles_mvvm.ui.main.article_details;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nytimesmostpopulararticles_mvvm.data.AppDataManager;
import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewModel;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;

public class ArticleDetailsViewModel extends BaseViewModel<ArticleDetailsNavigator> {
    private static final String TAG = "ArticleDetailsViewModel";
    private MutableLiveData<Boolean> isFavorite;

    public ArticleDetailsViewModel(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        super(application, appDataManager, schedulerProvider);
        isFavorite = new MutableLiveData<>();
    }

    public void insertArticle(Article article) {
        getCompositeDisposable().add(getAppDataManager().getDbRepository().insertArticle(article)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(b -> {
                    Log.d(TAG, "insertArticle: " + b);
                    isFavorite.setValue(true);
                }, throwable -> Log.d(TAG, "insertArticle: " + throwable.getMessage())));
    }

    public void deleteArticle(Article article) {
        getCompositeDisposable().add(getAppDataManager().getDbRepository().deleteArticle(article)
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

    public void onFavClick(boolean isFavorite, Article article) {
        if (isFavorite)
            deleteArticle(article);
        else
            insertArticle(article);
    }

    public LiveData<Boolean> getIsFavorite() {
        return isFavorite;
    }
}
