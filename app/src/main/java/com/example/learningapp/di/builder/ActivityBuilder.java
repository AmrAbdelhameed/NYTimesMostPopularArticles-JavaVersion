package com.example.learningapp.di.builder;

import com.example.learningapp.ui.main.MainActivity;
import com.example.learningapp.ui.main.MainActivityModule;
import com.example.learningapp.ui.main.article.ArticleFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,
            ArticleFragmentProvider.class})
    abstract MainActivity bindMainActivity();
}
