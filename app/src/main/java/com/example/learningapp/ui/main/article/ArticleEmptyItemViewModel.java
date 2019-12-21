package com.example.learningapp.ui.main.article;

public class ArticleEmptyItemViewModel {

    private ArticleEmptyItemViewModelListener mListener;

    public ArticleEmptyItemViewModel(ArticleEmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface ArticleEmptyItemViewModelListener {

        void onRetryClick();
    }
}
