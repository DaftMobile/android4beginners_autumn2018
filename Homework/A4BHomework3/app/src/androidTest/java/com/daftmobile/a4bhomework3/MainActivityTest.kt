package com.daftmobile.a4bhomework3

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.BundleMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.matcher.UriMatchers
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Konrad Kowalewski.
 */
class MainActivityTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)
    val stubEmail = "example@gmail.com"

    @Before
    fun setUp() {
        val cancelled = Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null)
        Intents.intending(IntentMatchers.anyIntent()).respondWith(cancelled)
        MainActivity.EMAIL_RETRIEVER = object : EmailRetriever {
            override fun retrieve(uri: Uri): String? = stubEmail
        }
    }

    @Test
    fun validateOutgoingIntent() {
        Espresso.onView(ViewMatchers.withId(R.id.sendMailButton)).perform(ViewActions.click())
        Intents.intended(contactsIntent())
    }

    @Test
    fun shouldNotOpenNextScreenWhenResultIsCancelled() {
        Espresso.onView(ViewMatchers.withId(R.id.sendMailButton)).perform(ViewActions.click())
        Intents.intended(sendEmailIntent(stubEmail), Intents.times(0))
    }

    @Test
    fun shouldOpenNextScreenWhenResultIsProvided() {
        val cancelled = Instrumentation.ActivityResult(Activity.RESULT_OK, Intent().setData(Uri.EMPTY))
        Intents.intending(contactsIntent()).respondWith(cancelled)
        Espresso.onView(ViewMatchers.withId(R.id.sendMailButton)).perform(ViewActions.click())
        Intents.intended(sendEmailIntent(stubEmail))
    }

    private fun contactsIntent(): Matcher<Intent> = CoreMatchers.allOf(
        IntentMatchers.hasAction(Intent.ACTION_PICK),
        IntentMatchers.hasType(ContactsContract.CommonDataKinds.Email.CONTENT_TYPE)
    )

    private fun sendEmailIntent(email: String): Matcher<Intent> = CoreMatchers.allOf(
        IntentMatchers.hasAction(Intent.ACTION_SENDTO),
        IntentMatchers.hasData(UriMatchers.hasScheme("mailto")),
        IntentMatchers.hasExtras(CoreMatchers.allOf(
            BundleMatchers.hasEntry(Intent.EXTRA_EMAIL, arrayOf(email)),
            BundleMatchers.hasKey(Intent.EXTRA_SUBJECT))
        )
    )
}
