package com.example.nytimesmostpopulararticles_mvvm.data.remote;

import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvvm.data.remote.network.ApiService;
import com.example.nytimesmostpopulararticles_mvvm.di.ApiInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class ApiRepository implements ApiDataSource {
    private ApiService apiService;
    private final String apiKey;

    @Inject
    public ApiRepository(ApiService apiService, @ApiInfo String apiKey) {
        this.apiService = apiService;
        this.apiKey = apiKey;
    }

    @Override
    public Single<ArticlesResponse> getArticles(int period) {
        return apiService.getArticles(period, apiKey);
    }
}
