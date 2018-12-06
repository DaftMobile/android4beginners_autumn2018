package com.daftmobile.android4beginners5.joke

import android.provider.Settings
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class JokeFetcher: JokeDataSource {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://switter.app.daftmobile.com/")
            .build()

    private val jokeApi = retrofit.create(JokeApi::class.java)

    override fun fetch(onSuccess: (String) -> Unit, onError: (String) -> Unit) {
        val call = jokeApi.getJoke(Settings.Secure.ANDROID_ID)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                onError(t.message ?: "No message")
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    onSuccess(response.body()?.string() ?: "Weird empty response")
                } else {
                    onError("Serwer zwrócił: ${response.code()}")
                }
            }
        })
//        synchronicznie:
//        val response = call.execute()
//        val body = response.body()?.string() ?: return onError("Nic nie wróciło")
//        onSuccess(body)
    }
}
