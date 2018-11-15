package com.daftmobile.a4bhomework2

import android.content.pm.ActivityInfo
import android.support.test.espresso.assertion.PositionAssertions
import android.support.test.espresso.matcher.ViewMatchers
import com.elpassion.android.commons.espresso.onText
import org.junit.Before
import org.junit.Test

class LandscapeHomeworkVerificationTest : HomeworkVerificationTest() {

    override val orientation get() = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    @Test
    fun testButtonsLayout() {
        onText("green")
                .check(PositionAssertions.isCompletelyRightOf(ViewMatchers.withText("red")))
                .check(PositionAssertions.isCompletelyLeftOf(ViewMatchers.withText("blue")))
    }
}
