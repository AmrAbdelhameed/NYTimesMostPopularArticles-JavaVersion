package com.example.learningapp.ui.main.article;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningapp.data.model.api.ArticlesResponse;
import com.example.learningapp.databinding.ItemArticleEmptyViewBinding;
import com.example.learningapp.databinding.ItemArticleViewBinding;
import com.example.learningapp.ui.base.BaseViewHolder;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<ArticlesResponse.Article> articles;

    private ArticleAdapterListener mListener;

    public ArticleAdapter(List<ArticlesResponse.Article> articles) {
        this.articles = articles;
    }

    @Override
    public int getItemCount() {
        if (articles != null && articles.size() > 0) {
            return articles.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (articles != null && !articles.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemArticleViewBinding articleViewBinding = ItemArticleViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new ArticleViewHolder(articleViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemArticleEmptyViewBinding emptyViewBinding = ItemArticleEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    public void addItems(List<ArticlesResponse.Article> articles) {
        this.articles.addAll(articles);
        notifyDataSetChanged();
    }

    public void clearItems() {
        articles.clear();
    }

    public void setListener(ArticleAdapterListener listener) {
        this.mListener = listener;
    }

    public interface ArticleAdapterListener {

        void onRetryClick();

        void onItemClick(ArticlesResponse.Article article);
    }

    public class ArticleViewHolder extends BaseViewHolder implements ArticleItemViewModel.ArticleItemViewModelListener {

        private ItemArticleViewBinding mBinding;

        private ArticleItemViewModel marticleItemViewModel;

        public ArticleViewHolder(ItemArticleViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final ArticlesResponse.Article article = articles.get(position);
            marticleItemViewModel = new ArticleItemViewModel(article, this);
            mBinding.setViewModel(marticleItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(ArticlesResponse.Article article) {
            if (article != null) {
                mListener.onItemClick(article);
            }
        }
    }

    public class EmptyViewHolder extends BaseViewHolder implements ArticleEmptyItemViewModel.ArticleEmptyItemViewModelListener {

        private ItemArticleEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemArticleEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            ArticleEmptyItemViewModel emptyItemViewModel = new ArticleEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();
        }
    }
}