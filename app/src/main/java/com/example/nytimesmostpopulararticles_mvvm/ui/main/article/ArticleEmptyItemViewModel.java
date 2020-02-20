package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseEmptyItemListener;

public class ArticleEmptyItemViewModel {

    private BaseEmptyItemListener mListener;

    public ArticleEmptyItemViewModel(BaseEmptyItemListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }
}
