package com.example.learningapp.ui.main.article;

import androidx.databinding.ObservableField;

import com.example.learningapp.data.model.api.Article;

public class ArticleItemViewModel {

    public final ArticleItemViewModelListener mListener;
    public final ObservableField<String> imageUrl;
    public final ObservableField<String> title;
    public final ObservableField<String> author;
    public final ObservableField<String> content;
    public final ObservableField<String> date;
    private final Article article;

    public ArticleItemViewModel(Article article, ArticleItemViewModelListener listener) {
        this.article = article;
        this.mListener = listener;
        imageUrl = new ObservableField<>(article.getMedia().get(0).getMediaMetadata().get(2).getUrl());
        title = new ObservableField<>(article.getTitle());
        author = new ObservableField<>(article.getByline());
        content = new ObservableField<>(article.getAbstract());
        date = new ObservableField<>(article.getPublishedDate());
    }

    public void onItemClick() {
        mListener.onItemClick(article);
    }

    public interface ArticleItemViewModelListener {

        void onItemClick(Article article);
    }
}
