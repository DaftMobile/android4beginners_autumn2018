package com.daftmobile.android4beginners4

import android.content.Context
import android.graphics.Color
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val liveData = LuminosityLiveData(sensorManager)
        liveData.observe(this, Observer(this::updateView))
    }

    private fun updateView(luminosity: Luminosity?) {
        if (luminosity == null) return
        luxView.text = luminosity.lux.toString()
        val background = Color.HSVToColor(floatArrayOf(50f, 0.5f, luminosity.fractionOfIndoorLight))
        colorView.setBackgroundColor(background)
    }
}
