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

    private static final int VIEW_TYPE_EMPTY = 0;
    private static final int VIEW_TYPE_NORMAL = 1;

    private List<Article> articles;
    private FavoritesAdapterListener mListener;

    public FavoritesAdapter(List<Article> articles) {
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
                return new FavoritesViewHolder(ItemFavoritesViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(ItemFavoritesEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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

        FavoritesViewHolder(ItemFavoritesViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final Article article = articles.get(position);
            mBinding.setViewModel(new FavoritesItemViewModel(article, this));
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

        EmptyViewHolder(ItemFavoritesEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            mBinding.setViewModel(new FavoritesEmptyItemViewModel());
            mBinding.executePendingBindings();
        }
    }
}