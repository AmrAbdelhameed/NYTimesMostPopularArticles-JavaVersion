package com.example.nytimesmostpopulararticles_mvvm.data.remote;

import com.example.nytimesmostpopulararticles_mvvm.BuildConfig;

public final class ApiEndPoint {

    public static final String ENDPOINT_ARTICLES = BuildConfig.BASE_URL + "/v2/viewed/{period}.json";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}
