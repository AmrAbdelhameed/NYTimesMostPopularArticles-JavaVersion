package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvvm.databinding.ItemArticleEmptyViewBinding;
import com.example.nytimesmostpopulararticles_mvvm.databinding.ItemArticleViewBinding;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewHolder;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final int VIEW_TYPE_EMPTY = 0;
    private static final int VIEW_TYPE_NORMAL = 1;

    private List<ArticlesResponse.Article> articles;
    private ArticleAdapterListener mListener;

    public ArticleAdapter(List<ArticlesResponse.Article> articles) {
        this.articles = articles;
    }

    @Override
    public int getItemCount() {
        return articles != null && articles.size() > 0 ? articles.size() : 1;
    }

    @Override
    public int getItemViewType(int position) {
        return articles != null && !articles.isEmpty() ? VIEW_TYPE_NORMAL : VIEW_TYPE_EMPTY;
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
                return new ArticleViewHolder(ItemArticleViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(ItemArticleEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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

        ArticleViewHolder(ItemArticleViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final ArticlesResponse.Article article = articles.get(position);
            mBinding.setViewModel(new ArticleItemViewModel(article, this));
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
}