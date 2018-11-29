package com.daftmobile.android4beginners4.robots.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daftmobile.android4beginners4.robots.model.ListRobotsDataSource

class ExternalSourceRobotsViewModel: ViewModel(), RobotsViewModel {

    private val mutableLiveData: MutableLiveData<String> = MutableLiveData()
    private val robotDataSource = ListRobotsDataSource()

    override fun getRobotList(): LiveData<String> = mutableLiveData

    override fun addRobot() = robotDataSource.addNew()
}
