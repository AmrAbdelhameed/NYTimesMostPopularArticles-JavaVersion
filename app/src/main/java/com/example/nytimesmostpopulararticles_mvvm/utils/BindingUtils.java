package com.example.nytimesmostpopulararticles_mvvm.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseRecyclerViewAdapter;

import java.util.List;

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter({"adapter"})
    public static <T> void setRecyclerViewData(RecyclerView recyclerView, List<T> items) {
        BaseRecyclerViewAdapter<T> adapter = (BaseRecyclerViewAdapter<T>) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(items);
        }
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    @BindingAdapter("imageUrlCrop")
    public static void setImageUrlCrop(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
    }
}
