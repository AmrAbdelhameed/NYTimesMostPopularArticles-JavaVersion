package com.example.nytimesmostpopulararticles_mvvm.data.remote;

import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;

import io.reactivex.Single;

public interface ApiHelper {

    Single<ArticlesResponse> getArticlesApiCall(int period);
}
