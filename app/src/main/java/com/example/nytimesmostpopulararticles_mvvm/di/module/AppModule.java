package com.example.nytimesmostpopulararticles_mvvm.di.module;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.nytimesmostpopulararticles_mvvm.BuildConfig;
import com.example.nytimesmostpopulararticles_mvvm.data.AppDataManager;
import com.example.nytimesmostpopulararticles_mvvm.data.DataManager;
import com.example.nytimesmostpopulararticles_mvvm.data.local.db.AppDatabase;
import com.example.nytimesmostpopulararticles_mvvm.data.local.db.AppDbHelper;
import com.example.nytimesmostpopulararticles_mvvm.data.local.db.DbHelper;
import com.example.nytimesmostpopulararticles_mvvm.data.local.prefs.AppPreferencesHelper;
import com.example.nytimesmostpopulararticles_mvvm.data.local.prefs.PreferencesHelper;
import com.example.nytimesmostpopulararticles_mvvm.data.remote.ApiHelper;
import com.example.nytimesmostpopulararticles_mvvm.data.remote.AppApiHelper;
import com.example.nytimesmostpopulararticles_mvvm.di.ApiInfo;
import com.example.nytimesmostpopulararticles_mvvm.di.DatabaseInfo;
import com.example.nytimesmostpopulararticles_mvvm.di.PreferenceInfo;
import com.example.nytimesmostpopulararticles_mvvm.utils.AppConstants;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.AppSchedulerProvider;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;
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
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration().build();
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
