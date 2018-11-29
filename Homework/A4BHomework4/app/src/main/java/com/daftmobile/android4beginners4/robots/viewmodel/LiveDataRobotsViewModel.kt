package com.daftmobile.android4beginners4.robots.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.daftmobile.android4beginners4.robots.model.Robot
import com.daftmobile.android4beginners4.robots.model.RobotGenerator

class LiveDataRobotsViewModel: RobotsViewModel {
    private val mutableLiveData: MutableLiveData<MutableList<Robot>> = MutableLiveData()

    override fun getRobotList(): LiveData<String> = Transformations.map(mutableLiveData) { list: List<Robot>? -> list.toString() }

    override fun addRobot() {
        val mutableList = mutableLiveData.value ?: mutableListOf()
        mutableList.add(RobotGenerator.generate())
        mutableLiveData.value = mutableList
    }
}
