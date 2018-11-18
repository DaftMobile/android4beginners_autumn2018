package com.daftmobile.android4beginners3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_color.*

class ColorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)
        colorView.setBackgroundColor(extractColorFromIntent())
    }

    private fun extractColorFromIntent(): Int {
        return 0
    }
}
