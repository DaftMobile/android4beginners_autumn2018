package com.daftmobile.a4bhomework2

import android.content.pm.ActivityInfo
import android.support.test.espresso.assertion.PositionAssertions
import android.support.test.espresso.matcher.ViewMatchers
import com.elpassion.android.commons.espresso.onText
import org.junit.Test

class PortraitHomeworkVerificationTest : HomeworkVerificationTest() {

    override val orientation get() = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    @Test
    fun testButtonsLayout() {
        onText("green")
                .check(PositionAssertions.isCompletelyBelow(ViewMatchers.withText("red")))
                .check(PositionAssertions.isCompletelyAbove(ViewMatchers.withText("blue")))
    }
}
