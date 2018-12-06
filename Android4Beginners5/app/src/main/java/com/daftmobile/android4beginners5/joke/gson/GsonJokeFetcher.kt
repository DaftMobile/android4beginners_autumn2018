package com.daftmobile.android4beginners5.joke.gson

import com.daftmobile.android4beginners5.joke.JokeDataSource
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class GsonJokeFetcher: JokeDataSource {

    private val client = OkHttpClient.Builder()
            .build()

    private val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://switter.app.daftmobile.com/")
//            .addConverterFactory(GsonConverterFactory.create())
            .build()

//    private val jokeApi = retrofit.create(JokeApi::class.java)

    override fun fetch(onSuccess: (String) -> Unit, onError: (String) -> Unit) = Unit
}
