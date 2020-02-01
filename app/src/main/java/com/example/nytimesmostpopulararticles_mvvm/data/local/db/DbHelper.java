package com.example.nytimesmostpopulararticles_mvvm.data.local.db;

import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {
    Observable<Boolean> insertArticle(Article article);

    Observable<Boolean> deleteArticle(Article article);

    Observable<Article> findById(long id);

    Observable<List<Article>> getAllArticles();
}
