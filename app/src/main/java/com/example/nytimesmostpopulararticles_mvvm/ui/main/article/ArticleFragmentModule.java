package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class ArticleFragmentModule {
    @Provides
    ArticleAdapter provideArticleAdapter() {
        return new ArticleAdapter(new ArrayList<>());
    }
}
