package com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;
import com.example.nytimesmostpopulararticles_mvvm.databinding.ItemFavoritesEmptyViewBinding;
import com.example.nytimesmostpopulararticles_mvvm.databinding.ItemFavoritesViewBinding;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewHolder;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<Article> articles;

    private FavoritesAdapterListener mListener;

    public FavoritesAdapter(List<Article> articles) {
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
                ItemFavoritesViewBinding favoritesViewBinding = ItemFavoritesViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new FavoritesViewHolder(favoritesViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemFavoritesEmptyViewBinding emptyViewBinding = ItemFavoritesEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    public void addItems(List<Article> articles) {
        this.articles.addAll(articles);
        notifyDataSetChanged();
    }

    public void clearItems() {
        articles.clear();
    }

    public void setListener(FavoritesAdapterListener listener) {
        this.mListener = listener;
    }

    public interface FavoritesAdapterListener {

        void onItemClick(Article article);
    }

    public class FavoritesViewHolder extends BaseViewHolder implements FavoritesItemViewModel.FavoritesItemViewModelListener {

        private ItemFavoritesViewBinding mBinding;

        private FavoritesItemViewModel mfavoritesItemViewModel;

        public FavoritesViewHolder(ItemFavoritesViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final Article article = articles.get(position);
            mfavoritesItemViewModel = new FavoritesItemViewModel(article, this);
            mBinding.setViewModel(mfavoritesItemViewModel);
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(Article article) {
            if (article != null) {
                mListener.onItemClick(article);
            }
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        private ItemFavoritesEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemFavoritesEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            FavoritesEmptyItemViewModel emptyItemViewModel = new FavoritesEmptyItemViewModel();
            mBinding.setViewModel(emptyItemViewModel);
        }
    }
}