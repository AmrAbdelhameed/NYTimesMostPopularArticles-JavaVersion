package com.example.nytimesmostpopulararticles_mvvm.data.local.prefs;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class PreferencesRepository implements PreferencesDataSource {
    private final SharedPreferences sharedPreferences;

    @Inject
    public PreferencesRepository(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
}
