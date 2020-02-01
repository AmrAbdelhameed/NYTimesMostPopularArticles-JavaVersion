package com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class FavoritesFragmentModule {

    @Provides
    FavoritesAdapter provideFavoritesAdapter() {
        return new FavoritesAdapter(new ArrayList<>());
    }
}
