@file:Suppress("unused")

package com.daftmobile.android4beginners5.joke

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface JokeApi {
    // /api/hello
    @GET("/api/hello")
    fun getHello(): Call<ResponseBody>

    // /api/joke
    @GET("/api/joke")
    fun getJoke(@Header("x-device-uuid") token: String): Call<ResponseBody>
}
