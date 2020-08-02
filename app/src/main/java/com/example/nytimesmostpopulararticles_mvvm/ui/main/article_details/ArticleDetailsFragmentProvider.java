package com.example.nytimesmostpopulararticles_mvvm.ui.main.article_details;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ArticleDetailsFragmentProvider {
    @ContributesAndroidInjector
    abstract ArticleDetailsFragment provideArticleDetailsFragmentFactory();
}
