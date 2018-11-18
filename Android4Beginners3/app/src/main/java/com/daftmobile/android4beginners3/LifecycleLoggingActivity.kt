package com.daftmobile.android4beginners3

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * Created by Konrad Kowalewski.
 */
abstract class LifecycleLoggingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate")
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart")
    }

    override fun onResume() {
        super.onResume()
        println("onResume")
    }

    override fun onPause() {
        println("onPause")
        super.onPause()
    }

    override fun onStop() {
        println("onStop")
        super.onStop()
    }

    override fun onDestroy() {
        println("onDestroy")
        super.onDestroy()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        println("onNewIntent: $intent")
    }

    private fun println(any: Any) {
        Log.d(javaClass.simpleName, any.toString())
    }
}
