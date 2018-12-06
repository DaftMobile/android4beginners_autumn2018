package com.daftmobile.android4beginners5.joke

import retrofit2.Retrofit

class JokeFetcher: JokeDataSource {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://switter.app.daftmobile.com/")
            .build()

    private val jokeApi = retrofit.create(JokeApi::class.java)

    override fun fetch(onSuccess: (String) -> Unit, onError: (String) -> Unit) {
//        call.execute
    }
}
