package com.example.learningapp;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.learningapp.data.DataManager;
import com.example.learningapp.ui.main.MainViewModel;
import com.example.learningapp.ui.main.article.ArticleViewModel;
import com.example.learningapp.ui.main.article_details.ArticleDetailsViewModel;
import com.example.learningapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(ArticleViewModel.class)) {
            //noinspection unchecked
            return (T) new ArticleViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(ArticleDetailsViewModel.class)) {
            //noinspection unchecked
            return (T) new ArticleDetailsViewModel(dataManager, schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}