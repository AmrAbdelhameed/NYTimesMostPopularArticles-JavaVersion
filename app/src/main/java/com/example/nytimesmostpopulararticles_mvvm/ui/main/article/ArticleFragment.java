package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.nytimesmostpopulararticles_mvvm.BR;
import com.example.nytimesmostpopulararticles_mvvm.R;
import com.example.nytimesmostpopulararticles_mvvm.ViewModelProviderFactory;
import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;
import com.example.nytimesmostpopulararticles_mvvm.databinding.FragmentArticleBinding;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseFragment;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.MainActivity;
import com.example.nytimesmostpopulararticles_mvvm.utils.AppConstants;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends BaseFragment<FragmentArticleBinding, ArticleViewModel>
        implements ArticleNavigator, ArticleAdapter.ArticleAdapterListener {
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
    public void onItemClick(ArticlesResponse.Article article) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(AppConstants.ARTICLE,
                new Article(article.getId()
                        , article.getMedia().get(0).getMediametadata().get(2).getUrl()
                        , article.getTitle()
                        , article.getByline()
                        , article.getAbstractX()
                        , article.getPublished_date()
                        , article.getUrl(),
                        article.getMedia().get(0).getMediametadata().get(1).getUrl()
                ));
        getNavController().navigate(R.id.action_articleFragment_to_articleDetailsFragment, bundle);
    }

    @Override
    public void handleError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<ArticlesResponse.Article> articles) {
        articleAdapter.addItems(articles);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articleViewModel.setNavigator(this);
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
