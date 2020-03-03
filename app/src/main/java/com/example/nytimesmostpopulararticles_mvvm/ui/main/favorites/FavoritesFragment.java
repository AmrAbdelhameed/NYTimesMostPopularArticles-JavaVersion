package com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.nytimesmostpopulararticles_mvvm.BR;
import com.example.nytimesmostpopulararticles_mvvm.R;
import com.example.nytimesmostpopulararticles_mvvm.ViewModelProviderFactory;
import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;
import com.example.nytimesmostpopulararticles_mvvm.databinding.FragmentFavoritesBinding;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseFragment;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.MainActivity;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.article.ArticleDataItem;
import com.example.nytimesmostpopulararticles_mvvm.utils.AppConstants;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends BaseFragment<FragmentFavoritesBinding, FavoritesViewModel>
        implements FavoritesNavigator, FavoritesAdapter.FavoritesAdapterListener {
    @Inject
    ViewModelProviderFactory factory;
    @Inject
    FavoritesAdapter favoritesAdapter;
    private FavoritesViewModel favoritesViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_favorites;
    }

    @Override
    public FavoritesViewModel getViewModel() {
        favoritesViewModel = new ViewModelProvider(this, factory).get(FavoritesViewModel.class);
        return favoritesViewModel;
    }

    @Override
    public void onItemClick(Article article) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(AppConstants.ARTICLE, new ArticleDataItem(article.getId()
                , article.getImageUrl()
                , article.getTitle()
                , article.getByline()
                , article.getAbstractX()
                , article.getPublishedDate()
                , article.getUrl()
                , article.getCoverImageUrl()));
        getNavController().navigate(R.id.action_favoritesFragment_to_articleDetailsFragment, bundle);
    }

    @Override
    public void handleError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<Article> articles) {
        favoritesAdapter.addItems(articles);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        favoritesViewModel.setNavigator(this);
        favoritesAdapter.setListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    private void setUp() {
        if (getActivity() != null) {
            ((MainActivity) getActivity()).setSupportActionBar(getViewDataBinding().toolbar);
            getViewDataBinding().toolbar.setTitle(getString(R.string.favorites));
            ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
            }
        }
        getViewDataBinding().toolbar.setNavigationOnClickListener(view -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });
        setHasOptionsMenu(true);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        getViewDataBinding().favoritesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getViewDataBinding().favoritesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        getViewDataBinding().favoritesRecyclerView.setAdapter(favoritesAdapter);
    }
}
