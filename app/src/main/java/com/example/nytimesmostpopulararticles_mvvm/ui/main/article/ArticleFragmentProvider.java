package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ArticleFragmentProvider {
    @ContributesAndroidInjector(modules = ArticleFragmentModule.class)
    abstract ArticleFragment provideArticleFragmentFactory();
}
