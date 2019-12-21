package com.example.learningapp.ui.main.article_details;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ArticleDetailsFragmentProvider {

    @ContributesAndroidInjector(modules = ArticleDetailsFragmentModule.class)
    abstract ArticleDetailsFragment provideArticleDetailsFragmentFactory();
}
