package com.daftmobile.android4beginners4.robots.viewmodel

import androidx.lifecycle.LiveData

interface RobotsViewModel {

    fun getRobotList(): LiveData<String>
    fun addRobot()
}
