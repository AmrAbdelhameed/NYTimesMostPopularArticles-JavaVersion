package com.example.learningapp.di.module;

import android.app.Application;
import android.content.Context;

import com.example.learningapp.BuildConfig;
import com.example.learningapp.data.AppDataManager;
import com.example.learningapp.data.DataManager;
import com.example.learningapp.data.local.db.AppDbHelper;
import com.example.learningapp.data.local.db.DbHelper;
import com.example.learningapp.data.local.prefs.AppPreferencesHelper;
import com.example.learningapp.data.local.prefs.PreferencesHelper;
import com.example.learningapp.data.remote.ApiHelper;
import com.example.learningapp.data.remote.AppApiHelper;
import com.example.learningapp.di.ApiInfo;
import com.example.learningapp.di.DatabaseInfo;
import com.example.learningapp.di.PreferenceInfo;
import com.example.learningapp.utils.AppConstants;
import com.example.learningapp.utils.rx.AppSchedulerProvider;
import com.example.learningapp.utils.rx.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
