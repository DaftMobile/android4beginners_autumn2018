package com.daftmobile.android4beginners5.joke

/**
 * Created by Konrad Kowalewski.
 */
interface JokeDataSource {

    fun fetch(onSuccess: (String) -> Unit, onError: (String) -> Unit)
}
