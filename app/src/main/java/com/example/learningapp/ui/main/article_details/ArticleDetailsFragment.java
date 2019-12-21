package com.example.learningapp.ui.main.article_details;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.learningapp.BR;
import com.example.learningapp.R;
import com.example.learningapp.ViewModelProviderFactory;
import com.example.learningapp.data.model.api.Article;
import com.example.learningapp.data.model.others.ArticleDetails;
import com.example.learningapp.databinding.FragmentArticleDetailsBinding;
import com.example.learningapp.ui.base.BaseFragment;
import com.example.learningapp.ui.main.MainActivity;
import com.example.learningapp.utils.AppConstants;

import java.util.Objects;

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
        articleDetailsViewModel = ViewModelProviders.of(this, factory).get(ArticleDetailsViewModel.class);
        return articleDetailsViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articleDetailsViewModel.setNavigator(this);
        if (getArguments() != null) {
            article = getArguments().getParcelable(AppConstants.ARTICLE);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentArticleDetailsBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        if (getActivity() != null) {
            ((MainActivity) getActivity()).setSupportActionBar(fragmentArticleDetailsBinding.toolbar);
            Objects.requireNonNull(((MainActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            Objects.requireNonNull(((MainActivity) getActivity()).getSupportActionBar()).setDisplayShowHomeEnabled(true);
            Objects.requireNonNull(((MainActivity) getActivity()).getSupportActionBar()).setDisplayShowTitleEnabled(false);
        }
        fragmentArticleDetailsBinding.toolbar.setNavigationOnClickListener(view -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });
        fragmentArticleDetailsBinding.setArticleDetails(
                new ArticleDetails(
                        article.getMedia().get(0).getMediaMetadata().get(2).getUrl()
                        , article.getTitle()
                        , article.getByline()
                        , article.getAbstract()
                        , article.getPublishedDate()
                        , article.getUrl()
                ));
    }
}
