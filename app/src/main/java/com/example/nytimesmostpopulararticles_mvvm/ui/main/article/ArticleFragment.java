package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.nytimesmostpopulararticles_mvvm.BR;
import com.example.nytimesmostpopulararticles_mvvm.R;
import com.example.nytimesmostpopulararticles_mvvm.ViewModelProviderFactory;
import com.example.nytimesmostpopulararticles_mvvm.databinding.FragmentArticleBinding;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseFragment;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.MainActivity;
import com.example.nytimesmostpopulararticles_mvvm.utils.AppConstants;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends BaseFragment<FragmentArticleBinding, ArticleViewModel>
        implements ArticleAdapter.ArticleAdapterListener {
    @Inject
    ViewModelProviderFactory factory;
    @Inject
    ArticleAdapter articleAdapter;
    private ArticleViewModel articleViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_article;
    }

    @Override
    public ArticleViewModel getViewModel() {
        articleViewModel = new ViewModelProvider(this, factory).get(ArticleViewModel.class);
        return articleViewModel;
    }

    @Override
    public void onRetryClick() {
        articleViewModel.getArticles(7);
    }

    @Override
    public void onItemClick(ArticleDataItem articleDataItem) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(AppConstants.ARTICLE, articleDataItem);
        if (getNavController().getCurrentDestination() != null) {
            if (getNavController().getCurrentDestination().getId() == R.id.articleFragment) {
                getNavController().navigate(R.id.action_articleFragment_to_articleDetailsFragment, bundle);
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articleAdapter.setListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    private void setUp() {
        if (getActivity() != null)
            ((MainActivity) getActivity()).setSupportActionBar(getViewDataBinding().toolbar);
        setHasOptionsMenu(true);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        getViewDataBinding().resultsBeanRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getViewDataBinding().resultsBeanRecyclerView.setItemAnimator(new DefaultItemAnimator());
        getViewDataBinding().resultsBeanRecyclerView.setAdapter(articleAdapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_favorites) {
            getNavController().navigate(R.id.action_articleFragment_to_favoritesFragment);
        }
        return super.onOptionsItemSelected(item);
    }
}
