package com.example.nytimesmostpopulararticles_mvvm.data;

import com.example.nytimesmostpopulararticles_mvvm.data.local.db.DbRepository;
import com.example.nytimesmostpopulararticles_mvvm.data.local.prefs.PreferencesRepository;
import com.example.nytimesmostpopulararticles_mvvm.data.remote.ApiRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {

    private final ApiRepository apiRepository;

    private final DbRepository dbRepository;

    private final PreferencesRepository preferencesRepository;

    @Inject
    public AppDataManager(ApiRepository apiRepository, DbRepository dbRepository, PreferencesRepository preferencesRepository) {
        this.apiRepository = apiRepository;
        this.dbRepository = dbRepository;
        this.preferencesRepository = preferencesRepository;
    }

    public ApiRepository getApiRepository() {
        return apiRepository;
    }

    public DbRepository getDbRepository() {
        return dbRepository;
    }

    public PreferencesRepository getPreferencesRepository() {
        return preferencesRepository;
    }
}
