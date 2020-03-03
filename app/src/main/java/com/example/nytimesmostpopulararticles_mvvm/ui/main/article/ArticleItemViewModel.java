package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import androidx.databinding.ObservableField;

import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseItemListener;

public class ArticleItemViewModel {

    private final ArticleDataItem articleDataItem;
    private final ArticleItemViewModelListener mListener;
    public final ObservableField<String> imageUrl;
    public final ObservableField<String> title;
    public final ObservableField<String> byline;
    public final ObservableField<String> publishedDate;

    public ArticleItemViewModel(ArticleDataItem articleDataItem, ArticleItemViewModelListener listener) {
        this.articleDataItem = articleDataItem;
        this.mListener = listener;
        imageUrl = new ObservableField<>(articleDataItem.getImageUrl());
        title = new ObservableField<>(articleDataItem.getTitle());
        byline = new ObservableField<>(articleDataItem.getByline());
        publishedDate = new ObservableField<>(articleDataItem.getPublishedDate());
    }

    public void onItemClick() {
        mListener.onItemClick(articleDataItem);
    }

    public interface ArticleItemViewModelListener extends BaseItemListener<ArticleDataItem> {

    }
}
