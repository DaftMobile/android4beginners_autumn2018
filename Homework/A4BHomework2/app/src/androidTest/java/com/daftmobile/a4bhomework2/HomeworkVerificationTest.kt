package com.daftmobile.a4bhomework2

import android.R
import android.support.test.espresso.matcher.RootMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.elpassion.android.commons.espresso.click
import com.elpassion.android.commons.espresso.doesNotExist
import com.elpassion.android.commons.espresso.isDisplayed
import com.elpassion.android.commons.espresso.onText
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@Suppress("unused")
@RunWith(AndroidJUnit4::class)
abstract class HomeworkVerificationTest {

    protected abstract val orientation: Int

    @Rule
    @JvmField
    val rule = object : ActivityTestRule<MainActivity>(MainActivity::class.java) {
        override fun afterActivityLaunched() {
            activity.requestedOrientation = orientation
            Thread.sleep(500)
        }
    }

    @Test
    fun shouldShowDialogWhenRedButtonTapped() {
        checkDialogFlowForButton("red")
    }

    @Test
    fun shouldShowDialogWhenGreenButtonTapped() {
        checkDialogFlowForButton("green")
    }

    @Test
    fun shouldShowDialogWhenBlueButtonTapped() {
        checkDialogFlowForButton("blue")
    }

    private fun checkDialogFlowForButton(label: String) {
        onText(label).isDisplayed().click()
        onText("Button $label was tapped").inRoot(RootMatchers.isDialog()).isDisplayed()
        onText(R.string.ok).click().doesNotExist()
    }
}
