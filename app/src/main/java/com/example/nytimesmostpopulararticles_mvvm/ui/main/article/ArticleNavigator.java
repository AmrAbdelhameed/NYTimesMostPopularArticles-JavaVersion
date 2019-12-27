package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;

import java.util.List;

public interface ArticleNavigator {

    void handleError(Throwable throwable);

    void updateArticle(List<ArticlesResponse.Article> articles);
}
