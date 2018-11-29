package com.daftmobile.android4beginners4.robots

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daftmobile.android4beginners4.robots.viewmodel.RobotsViewModel
import kotlinx.android.synthetic.main.activity_robots.*

class RobotsActivity : AppCompatActivity() {
    private lateinit var viewModel: RobotsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robots)

        addRobotFab.setOnClickListener {
            addNewItem()
        }
    }

    private fun addNewItem() {
        viewModel.addRobot()
    }
}
