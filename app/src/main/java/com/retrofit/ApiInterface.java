package com.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zoomi on 01-Nov-17.
 */

public interface ApiInterface {

  @GET("movie/top_rated")
  Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

  @GET("movie/{id}")
  Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
