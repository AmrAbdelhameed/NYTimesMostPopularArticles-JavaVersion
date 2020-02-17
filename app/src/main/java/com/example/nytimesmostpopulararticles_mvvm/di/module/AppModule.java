package com.example.nytimesmostpopulararticles_mvvm.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;

import com.example.nytimesmostpopulararticles_mvvm.BuildConfig;
import com.example.nytimesmostpopulararticles_mvvm.data.local.db.AppDatabase;
import com.example.nytimesmostpopulararticles_mvvm.data.remote.network.ApiService;
import com.example.nytimesmostpopulararticles_mvvm.di.ApiInfo;
import com.example.nytimesmostpopulararticles_mvvm.di.DatabaseInfo;
import com.example.nytimesmostpopulararticles_mvvm.di.PreferenceInfo;
import com.example.nytimesmostpopulararticles_mvvm.utils.AppConstants;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.AppSchedulerProvider;
import com.example.nytimesmostpopulararticles_mvvm.utils.rx.SchedulerProvider;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration().build();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(@PreferenceInfo String prefName, Context context) {
        return context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
