package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import androidx.databinding.ObservableField;

import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseItemListener;

public class ArticleItemViewModel {

    private final ArticlesResponse.Article article;
    private final ArticleItemViewModelListener mListener;
    public final ObservableField<String> imageUrl;
    public final ObservableField<String> title;
    public final ObservableField<String> byline;
    public final ObservableField<String> publishedDate;

    public ArticleItemViewModel(ArticlesResponse.Article article, ArticleItemViewModelListener listener) {
        this.article = article;
        this.mListener = listener;
        imageUrl = new ObservableField<>(article.getMedia().get(0).getMediametadata().get(1).getUrl());
        title = new ObservableField<>(article.getTitle());
        byline = new ObservableField<>(article.getByline());
        publishedDate = new ObservableField<>(article.getPublished_date());
    }

    public void onItemClick() {
        mListener.onItemClick(article);
    }

    public interface ArticleItemViewModelListener extends BaseItemListener<ArticlesResponse.Article> {

    }
}
