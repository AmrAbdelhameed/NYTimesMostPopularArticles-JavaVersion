package com.example.nytimesmostpopulararticles_mvvm.data;

import android.content.Context;

import com.example.nytimesmostpopulararticles_mvvm.data.local.db.DbHelper;
import com.example.nytimesmostpopulararticles_mvvm.data.local.prefs.PreferencesHelper;
import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvvm.data.remote.ApiHelper;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final DbHelper mDbHelper;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mGson = gson;
    }

    @Override
    public Single<ArticlesResponse> getArticlesApiCall(int period) {
        return mApiHelper.getArticlesApiCall(period);
    }
}
