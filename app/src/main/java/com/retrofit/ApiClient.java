package com.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zoomi on 01-Nov-17.
 */

public class ApiClient {

  public static final String BASE_URL = "http://api.themoviedb.org/3/";
  private static Retrofit retrofit = null;


  public static Retrofit getClient() {
    if (retrofit == null) {

      HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
      logging.setLevel(Level.BODY);
      OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
      httpClient.addInterceptor(logging);

      retrofit = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .client(httpClient.build())
          .build();
    }
    return retrofit;
  }
}
