package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.nytimesmostpopulararticles_mvvm.databinding.ItemArticleEmptyViewBinding;
import com.example.nytimesmostpopulararticles_mvvm.databinding.ItemArticleViewBinding;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseEmptyItemListener;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseItemListener;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseRecyclerViewAdapter;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewHolder;

import java.util.List;

import static com.example.nytimesmostpopulararticles_mvvm.utils.AppConstants.VIEW_TYPE_EMPTY;
import static com.example.nytimesmostpopulararticles_mvvm.utils.AppConstants.VIEW_TYPE_NORMAL;

public class ArticleAdapter extends BaseRecyclerViewAdapter<ArticleDataItem> {
    private ArticleAdapterListener mListener;

    public ArticleAdapter(List<ArticleDataItem> articleDataItems) {
        super(articleDataItems);
    }

    public void setListener(ArticleAdapterListener listener) {
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {
        return getItems() != null && getItems().size() > 0 ? getItems().size() : 1;
    }

    @Override
    public int getItemViewType(int position) {
        return getItems() != null && !getItems().isEmpty() ? VIEW_TYPE_NORMAL : VIEW_TYPE_EMPTY;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ArticleViewHolder(ItemArticleViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(ItemArticleEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }
    }

    public class ArticleViewHolder extends BaseViewHolder implements ArticleItemViewModel.ArticleItemViewModelListener {
        private ItemArticleViewBinding mBinding;

        ArticleViewHolder(ItemArticleViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            mBinding.setViewModel(new ArticleItemViewModel(getItems().get(position), this));
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(ArticleDataItem articleDataItem) {
            if (articleDataItem != null) {
                mListener.onItemClick(articleDataItem);
            }
        }
    }

    public class EmptyViewHolder extends BaseViewHolder implements BaseEmptyItemListener {
        private ItemArticleEmptyViewBinding mBinding;

        EmptyViewHolder(ItemArticleEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            mBinding.setViewModel(new ArticleEmptyItemViewModel(this));
            mBinding.executePendingBindings();
        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();
        }
    }

    public interface ArticleAdapterListener extends BaseItemListener<ArticleDataItem>, BaseEmptyItemListener {

    }
}