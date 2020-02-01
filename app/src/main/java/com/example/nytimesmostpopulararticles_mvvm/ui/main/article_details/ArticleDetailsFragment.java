package com.example.nytimesmostpopulararticles_mvvm.ui.main.article_details;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.nytimesmostpopulararticles_mvvm.BR;
import com.example.nytimesmostpopulararticles_mvvm.R;
import com.example.nytimesmostpopulararticles_mvvm.ViewModelProviderFactory;
import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;
import com.example.nytimesmostpopulararticles_mvvm.databinding.FragmentArticleDetailsBinding;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseFragment;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.MainActivity;
import com.example.nytimesmostpopulararticles_mvvm.utils.AppConstants;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleDetailsFragment extends BaseFragment<FragmentArticleDetailsBinding, ArticleDetailsViewModel>
        implements ArticleDetailsNavigator {
    @Inject
    ViewModelProviderFactory factory;
    private FragmentArticleDetailsBinding fragmentArticleDetailsBinding;
    private ArticleDetailsViewModel articleDetailsViewModel;
    private Article article;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_article_details;
    }

    @Override
    public ArticleDetailsViewModel getViewModel() {
        articleDetailsViewModel = new ViewModelProvider(this, factory).get(ArticleDetailsViewModel.class);
        return articleDetailsViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articleDetailsViewModel.setNavigator(this);
        if (getArguments() != null) {
            article = getArguments().getParcelable(AppConstants.ARTICLE);
            if (article != null) {
                // To check if article is favorite or not
                articleDetailsViewModel.findById(article.getId());
            }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentArticleDetailsBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        setUpToolbar();
        setArticle();
    }

    private void setArticle() {
        if (article != null) {
            fragmentArticleDetailsBinding.setArticle(article);
        }
    }

    private void setUpToolbar() {
        if (getActivity() != null) {
            ((MainActivity) getActivity()).setSupportActionBar(fragmentArticleDetailsBinding.toolbar);
            ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(false);
            }
        }
        fragmentArticleDetailsBinding.toolbar.setNavigationOnClickListener(view -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });
    }
}
