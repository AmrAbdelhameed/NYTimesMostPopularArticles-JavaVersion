package com.example.nytimesmostpopulararticles_mvvm.data.remote;

import com.example.nytimesmostpopulararticles_mvvm.BuildConfig;
import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {

    }

    @Override
    public Single<ArticlesResponse> getArticlesApiCall(int period) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_ARTICLES)
                .addQueryParameter("api-key", BuildConfig.API_KEY)
                .addPathParameter("period", String.valueOf(period))
                .build()
                .getObjectSingle(ArticlesResponse.class);
    }
}
