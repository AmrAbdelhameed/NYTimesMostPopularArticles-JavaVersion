package com.example.nytimesmostpopulararticles_mvvm.di.builder;

import com.example.nytimesmostpopulararticles_mvvm.ui.main.MainActivity;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.MainActivityModule;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.article.ArticleFragmentProvider;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.article_details.ArticleDetailsFragmentProvider;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites.FavoritesFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,
            ArticleFragmentProvider.class,
            ArticleDetailsFragmentProvider.class,
            FavoritesFragmentProvider.class})
    abstract MainActivity bindMainActivity();
}
