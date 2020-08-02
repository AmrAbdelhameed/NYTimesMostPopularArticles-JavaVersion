package com.example.nytimesmostpopulararticles_mvvm.data.remote.network;

import com.example.nytimesmostpopulararticles_mvvm.data.model.api.ArticlesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET(ApiEndPoint.ENDPOINT_ARTICLES)
    Single<ArticlesResponse> getArticles(@Path("period") int period, @Query("api-key") String apiKey);
}
