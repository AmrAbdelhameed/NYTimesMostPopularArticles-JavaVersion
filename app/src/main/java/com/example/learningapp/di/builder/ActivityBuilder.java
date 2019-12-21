package com.example.learningapp.di.builder;

import com.example.learningapp.ui.main.MainActivity;
import com.example.learningapp.ui.main.MainActivityModule;
import com.example.learningapp.ui.main.article.ArticleFragmentProvider;
import com.example.learningapp.ui.main.article_details.ArticleDetailsFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,
            ArticleFragmentProvider.class,
            ArticleDetailsFragmentProvider.class})
    abstract MainActivity bindMainActivity();
}
