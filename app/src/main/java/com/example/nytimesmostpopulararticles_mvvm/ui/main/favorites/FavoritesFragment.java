package com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.nytimesmostpopulararticles_mvvm.BR;
import com.example.nytimesmostpopulararticles_mvvm.R;
import com.example.nytimesmostpopulararticles_mvvm.ViewModelProviderFactory;
import com.example.nytimesmostpopulararticles_mvvm.data.model.db.Article;
import com.example.nytimesmostpopulararticles_mvvm.databinding.FragmentFavoritesBinding;
import com.example.nytimesmostpopulararticles_mvvm.ui.base.BaseFragment;
import com.example.nytimesmostpopulararticles_mvvm.ui.main.MainActivity;
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
    private FragmentFavoritesBinding fragmentFavoritesBinding;
    private FavoritesViewModel favoritesViewModel;
    private NavController navController;

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
        bundle.putParcelable(AppConstants.ARTICLE, article);
        navController.navigate(R.id.action_favoritesFragment_to_articleDetailsFragment, bundle);
    }

    @Override
    public void handleError(Throwable throwable) {
        Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateArticle(List<Article> articles) {
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
        fragmentFavoritesBinding = getViewDataBinding();
        navController = Navigation.findNavController(view);
        setUp();
    }

    private void setUp() {
        if (getActivity() != null) {
            ((MainActivity) getActivity()).setSupportActionBar(fragmentFavoritesBinding.toolbar);
            fragmentFavoritesBinding.toolbar.setTitle(getString(R.string.favorites));
            ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
            }
        }
        fragmentFavoritesBinding.toolbar.setNavigationOnClickListener(view -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });
        setHasOptionsMenu(true);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        fragmentFavoritesBinding.favoritesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentFavoritesBinding.favoritesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        fragmentFavoritesBinding.favoritesRecyclerView.setAdapter(favoritesAdapter);
    }
}
