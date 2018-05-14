package com.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (API_KEY.isEmpty()) {
            Toast
                    .makeText(applicationContext, "Please obtain your API KEY first from themoviedb.org",
                            Toast.LENGTH_LONG).show()
            return
        }

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        val recyclerView = findViewById<RecyclerView>(R.id.movies_recycler_view)
        recyclerView.layoutManager = linearLayoutManager

        val apiService = ApiClient.client.create(ApiInterface::class.java)

        val call = apiService.getTopRatedMovies(API_KEY)
        call.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                val movies = response.body()!!.results
                recyclerView.adapter = MoviesAdapter(movies!!, R.layout.list_item_movie)
                Log.d(TAG, "Number of movies received: " + movies.size)
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                // Log error here since request failed
                Log.e(TAG, t.toString())
            }
        })
    }

    companion object {

        private val TAG = MainActivity::class.java.simpleName

        // TODO - insert your themoviedb.org API KEY here
        private val API_KEY = "4a78f3aa70b93c4d149f9d8c724e663c"
    }
}