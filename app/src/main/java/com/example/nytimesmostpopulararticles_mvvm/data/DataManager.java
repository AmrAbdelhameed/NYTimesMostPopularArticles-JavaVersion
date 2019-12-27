package com.example.nytimesmostpopulararticles_mvvm.data;

import com.example.nytimesmostpopulararticles_mvvm.data.local.db.DbHelper;
import com.example.nytimesmostpopulararticles_mvvm.data.local.prefs.PreferencesHelper;
import com.example.nytimesmostpopulararticles_mvvm.data.remote.ApiHelper;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {
}
