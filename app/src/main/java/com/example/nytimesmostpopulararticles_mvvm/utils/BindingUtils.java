package com.example.nytimesmostpopulararticles_mvvm.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.article.ArticleAdapter;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites.FavoritesAdapter;

import java.util.List;

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addArticleItems(RecyclerView recyclerView, List<ArticlesResponse.Article> articles) {
        ArticleAdapter adapter = (ArticleAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(articles);
        }
    }

    @BindingAdapter({"adapter_fav"})
    public static void addFavoritesItems(RecyclerView recyclerView, List<Article> articles) {
        FavoritesAdapter adapter = (FavoritesAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(articles);
        }
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter("imageUrlCrop")
    public static void setImageUrlCrop(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).apply(RequestOptions.circleCropTransform()).into(imageView);
    }
}
