package com.example.learningapp.ui.main.article;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.learningapp.BR;
import com.example.learningapp.R;
import com.example.learningapp.ViewModelProviderFactory;
import com.example.learningapp.data.model.api.ArticlesResponse;
import com.example.learningapp.databinding.FragmentArticleBinding;
import com.example.learningapp.ui.base.BaseFragment;
import com.example.learningapp.ui.main.MainActivity;
import com.example.learningapp.ui.main.article_details.ArticleDetailsFragment;
import com.example.learningapp.utils.AppConstants;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends BaseFragment<FragmentArticleBinding, ArticleViewModel>
        implements ArticleNavigator, ArticleAdapter.ArticleAdapterListener {
    @Inject
    ArticleAdapter articleAdapter;
    @Inject
    ViewModelProviderFactory factory;
    private FragmentArticleBinding fragmentArticleBinding;
    private ArticleViewModel articleViewModel;

    public static ArticleFragment newInstance() {
        Bundle args = new Bundle();
        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }

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
        articleViewModel = ViewModelProviders.of(this, factory).get(ArticleViewModel.class);
        return articleViewModel;
    }

    @Override
    public void onRetryClick() {
        articleViewModel.fetchArticles(7);
    }

    @Override
    public void onItemClick(ArticlesResponse.Article article) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(AppConstants.ARTICLE, article);
        if (getActivity() != null) {
            ((MainActivity) getActivity()).replaceCurrentFragment(bundle, new ArticleDetailsFragment());
        }
    }

    @Override
    public void handleError(Throwable throwable) {
        Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateArticle(List<ArticlesResponse.Article> articles) {
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
        fragmentArticleBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        if (getActivity() != null) {
            ((MainActivity) getActivity()).setSupportActionBar(fragmentArticleBinding.toolbar);
        }
        fragmentArticleBinding.resultsBeanRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentArticleBinding.resultsBeanRecyclerView.setItemAnimator(new DefaultItemAnimator());
        fragmentArticleBinding.resultsBeanRecyclerView.setAdapter(articleAdapter);
    }
}
