package com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;
import com.example.nytimesmostpopulararticles_mvvm.databinding.ItemFavoritesEmptyViewBinding;
import com.example.nytimesmostpopulararticles_mvvm.databinding.ItemFavoritesViewBinding;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseRecyclerViewAdapter;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseItemListener;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseViewHolder;

import java.util.List;

import static com.example.nytimesmostpopulararticles_mvvm.utils.AppConstants.VIEW_TYPE_EMPTY;
import static com.example.nytimesmostpopulararticles_mvvm.utils.AppConstants.VIEW_TYPE_NORMAL;

public class FavoritesAdapter extends BaseRecyclerViewAdapter<Article> {

    private FavoritesAdapterListener mListener;

    public FavoritesAdapter(List<Article> articles) {
        super(articles);
    }

    public void setListener(FavoritesAdapterListener listener) {
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

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
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

    public interface FavoritesAdapterListener extends BaseItemListener<Article> {

    }

    public class FavoritesViewHolder extends BaseViewHolder implements FavoritesItemViewModel.FavoritesItemViewModelListener {

        private ItemFavoritesViewBinding mBinding;

        FavoritesViewHolder(ItemFavoritesViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final Article article = getItems().get(position);
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