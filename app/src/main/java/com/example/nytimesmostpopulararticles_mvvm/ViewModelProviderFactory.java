package com.example.nytimesmostpopulararticles_mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.nytimesmostpopulararticles_mvvm.data.AppDataManager;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.MainViewModel;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.article.ArticleViewModel;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.article_details.ArticleDetailsViewModel;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites.FavoritesViewModel;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {
    private final Application application;
    private final AppDataManager appDataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        this.application = application;
        this.appDataManager = appDataManager;
        this.schedulerProvider = schedulerProvider;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(application, appDataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(ArticleViewModel.class)) {
            //noinspection unchecked
            return (T) new ArticleViewModel(application, appDataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(ArticleDetailsViewModel.class)) {
            //noinspection unchecked
            return (T) new ArticleDetailsViewModel(application, appDataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(FavoritesViewModel.class)) {
            //noinspection unchecked
            return (T) new FavoritesViewModel(application, appDataManager, schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}