package com.example.learningapp.ui.main.article;

import com.example.learningapp.data.model.api.ArticlesResponse;

import java.util.List;

public interface ArticleNavigator {

    void handleError(Throwable throwable);

    void updateArticle(List<ArticlesResponse.Article> articles);
}
