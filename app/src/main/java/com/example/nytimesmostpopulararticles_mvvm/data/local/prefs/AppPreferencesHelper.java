package com.example.nytimesmostpopulararticles_mvvm.data.local.prefs;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences sharedPreferences;

    @Inject
    public AppPreferencesHelper(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
}
