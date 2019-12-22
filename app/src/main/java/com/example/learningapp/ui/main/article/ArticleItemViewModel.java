package com.example.learningapp.ui.main.article;

import androidx.databinding.ObservableField;

import com.example.learningapp.data.model.api.ArticlesResponse;

public class ArticleItemViewModel {

    public final ArticleItemViewModelListener mListener;
    public final ObservableField<String> imageUrl;
    public final ObservableField<String> title;
    public final ObservableField<String> author;
    public final ObservableField<String> date;
    private final ArticlesResponse.Article article;

    public ArticleItemViewModel(ArticlesResponse.Article article, ArticleItemViewModelListener listener) {
        this.article = article;
        this.mListener = listener;
        imageUrl = new ObservableField<>(article.getMedia().get(0).getMediametadata().get(1).getUrl());
        title = new ObservableField<>(article.getTitle());
        author = new ObservableField<>(article.getByline());
        date = new ObservableField<>(article.getPublished_date());
    }

    public void onItemClick() {
        mListener.onItemClick(article);
    }

    public interface ArticleItemViewModelListener {

        void onItemClick(ArticlesResponse.Article article);
    }
}
