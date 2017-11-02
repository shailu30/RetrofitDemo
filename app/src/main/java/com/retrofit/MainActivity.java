package com.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  // TODO - insert your themoviedb.org API KEY here
  private final static String API_KEY = "4a78f3aa70b93c4d149f9d8c724e663c";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (API_KEY.isEmpty()) {
      Toast
          .makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org",
              Toast.LENGTH_LONG).show();
      return;
    }

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

    final RecyclerView recyclerView = findViewById(R.id.movies_recycler_view);
    recyclerView.setLayoutManager(linearLayoutManager);

    ApiInterface apiService =
        ApiClient.getClient().create(ApiInterface.class);

    Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
    call.enqueue(new Callback<MoviesResponse>() {
      @Override
      public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
        List<Movie> movies = response.body().getResults();
        recyclerView.setAdapter(
            new MoviesAdapter(movies, R.layout.list_item_movie));
        Log.d(TAG, "Number of movies received: " + movies.size());
      }

      @Override
      public void onFailure(Call<MoviesResponse> call, Throwable t) {
        // Log error here since request failed
        Log.e(TAG, t.toString());
      }
    });
  }
}
