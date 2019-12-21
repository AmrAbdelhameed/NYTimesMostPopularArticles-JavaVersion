package com.example.learningapp.ui.main.article;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class ArticleFragmentModule {

    @Provides
    ArticleAdapter provideArticleAdapter() {
        return new ArticleAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(ArticleFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
