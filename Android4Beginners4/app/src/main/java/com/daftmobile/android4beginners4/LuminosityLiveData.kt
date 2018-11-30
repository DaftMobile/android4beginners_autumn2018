package com.daftmobile.android4beginners4

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.LiveData

class LuminosityLiveData(private val sensorManager: SensorManager) : LiveData<Luminosity>() {
    private val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

    override fun onActive() {
        // ta metoda zostaje wywołana, kiedy liczba AKTYWNYCH obserwatorów instancji tej klasy zmieni się z 0 na dowolną liczbę
        println("I have an active observer!")
        sensorManager.registerListener(sensorListener, lightSensor, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onInactive() {
        // ta metoda zostaje wywołana, kiedy liczba AKTYWNYCH obserwatorów instancji tej klasy spadnie do zera
        println("I lost all active observers! Sleep...")
        sensorManager.unregisterListener(sensorListener)
    }

    // ten obiekt otrzymuje zmiany wartości sensora i ustawia otrzymaną wartość jako aktualne VALUE tej LiveData
    private val sensorListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) = Unit

        override fun onSensorChanged(event: SensorEvent) {
            value = Luminosity(event.values[0])
        }
    }
}
