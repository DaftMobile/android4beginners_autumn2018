package com.daftmobile.android4beginners4.robots.model


interface RobotsDataSource {
    fun getRobots(): List<Robot>
    fun addNew(robot: Robot = RobotGenerator.generate())
}
