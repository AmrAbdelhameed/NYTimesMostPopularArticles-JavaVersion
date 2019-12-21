package com.example.learningapp.utils;

import com.example.learningapp.BuildConfig;

public final class AppConstants {

    public static final String DB_NAME = BuildConfig.APPLICATION_ID + ".db";

    public static final String PREF_NAME = BuildConfig.APPLICATION_ID + "_pref";

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public static final String ARTICLE = "article";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
