package com.example.learningapp.data.remote;

import com.example.learningapp.data.model.api.ArticlesResponse;

import io.reactivex.Single;

public interface ApiHelper {

    Single<ArticlesResponse> getArticlesApiCall();
}
