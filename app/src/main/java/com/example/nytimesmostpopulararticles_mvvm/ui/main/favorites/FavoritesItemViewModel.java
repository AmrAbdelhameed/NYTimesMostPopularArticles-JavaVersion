package com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites;

import androidx.databinding.ObservableField;

import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseItemListener;

public class FavoritesItemViewModel {
    private final Article article;
    private final FavoritesItemViewModelListener mListener;
    public final ObservableField<String> imageUrl;
    public final ObservableField<String> title;
    public final ObservableField<String> byline;
    public final ObservableField<String> publishedDate;

    public FavoritesItemViewModel(Article article, FavoritesItemViewModelListener listener) {
        this.article = article;
        this.mListener = listener;
        imageUrl = new ObservableField<>(article.getImageUrl());
        title = new ObservableField<>(article.getTitle());
        byline = new ObservableField<>(article.getByline());
        publishedDate = new ObservableField<>(article.getPublishedDate());
    }

    public void onItemClick() {
        mListener.onItemClick(article);
    }

    public interface FavoritesItemViewModelListener extends BaseItemListener<Article> {

    }
}
