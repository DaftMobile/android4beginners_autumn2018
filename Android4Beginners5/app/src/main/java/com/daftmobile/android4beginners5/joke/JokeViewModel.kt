package com.daftmobile.android4beginners5.joke

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.daftmobile.android4beginners5.SingleLiveEvent

class JokeViewModel: ViewModel() {
    private val jokeDataSource: JokeDataSource = JokeFetcher()

    private val responseLiveData = MutableLiveData<String>()
    private val errorLiveData = SingleLiveEvent<String>()
    private val loaderVisibleData = MutableLiveData<Boolean>()

    fun response(): LiveData<String> = responseLiveData
    fun error(): LiveData<String> = errorLiveData
    fun loaderVisible(): LiveData<Boolean> = loaderVisibleData

    fun call() {
        fetchDataFromApi()
    }

    private fun fetchDataFromApi() {
        jokeDataSource.fetch({
            responseLiveData.setValue(it)
        }, {
            errorLiveData.value = it
        })
    }
}
