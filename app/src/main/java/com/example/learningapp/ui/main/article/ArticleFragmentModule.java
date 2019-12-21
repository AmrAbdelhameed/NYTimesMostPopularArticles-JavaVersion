package com.example.learningapp.ui.main.article;

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
