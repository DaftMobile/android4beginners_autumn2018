package com.daftmobile.android4beginners4.robots.model

object RobotGenerator {
    private val names = arrayOf(
            "BB8",
            "R2-D2",
            "C-3PO",
            "IG-88",
            "IG-100",
            "Wall-e",
            "Curiosity",
            "Opportunity",
            "Pathfinder",
            "Spirit"
    )

    private var index = 0

    fun generate(): Robot = Robot(
        index++,
        names.random(),
        Robot.Mood.values().random()
    )
}
