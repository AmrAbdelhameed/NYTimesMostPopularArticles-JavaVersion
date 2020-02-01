package com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites;

import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;

import java.util.List;

public interface FavoritesNavigator {

    void handleError(Throwable throwable);

    void updateArticle(List<Article> articles);
}
