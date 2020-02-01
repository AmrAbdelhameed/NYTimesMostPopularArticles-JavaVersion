package com.example.nytimesmostpopulararticles_mvvm.ui.main.favorites;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FavoritesFragmentProvider {

    @ContributesAndroidInjector(modules = FavoritesFragmentModule.class)
    abstract FavoritesFragment provideFavoritesFragmentFactory();
}
