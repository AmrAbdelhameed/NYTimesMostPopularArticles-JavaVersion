package com.example.nytimesmostpopulararticles_mvvm.data;

import com.example.nytimesmostpopulararticles_mvvm.data.local.db.AppDbHelper;
import com.example.nytimesmostpopulararticles_mvvm.data.local.prefs.AppPreferencesHelper;
import com.example.nytimesmostpopulararticles_mvvm.data.remote.AppApiHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {

    private final AppApiHelper appApiHelper;

    private final AppDbHelper appDbHelper;

    private final AppPreferencesHelper appPreferencesHelper;

    @Inject
    public AppDataManager(AppApiHelper appApiHelper, AppDbHelper appDbHelper, AppPreferencesHelper appPreferencesHelper) {
        this.appApiHelper = appApiHelper;
        this.appDbHelper = appDbHelper;
        this.appPreferencesHelper = appPreferencesHelper;
    }

    public AppApiHelper getAppApiHelper() {
        return appApiHelper;
    }

    public AppDbHelper getAppDbHelper() {
        return appDbHelper;
    }

    public AppPreferencesHelper getAppPreferencesHelper() {
        return appPreferencesHelper;
    }
}
