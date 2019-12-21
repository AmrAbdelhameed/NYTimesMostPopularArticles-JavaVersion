package com.example.learningapp.data;

import com.example.learningapp.data.local.db.DbHelper;
import com.example.learningapp.data.local.prefs.PreferencesHelper;
import com.example.learningapp.data.remote.ApiHelper;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {
}
