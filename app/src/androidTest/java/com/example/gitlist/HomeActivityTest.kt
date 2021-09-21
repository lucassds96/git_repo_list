package com.example.gitlist

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.gitlist.ui.home.HomeActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    private val activityClass = HomeActivity::class.java

    @get:Rule internal val activityTestRule = ActivityTestRule<HomeActivity>(activityClass, false, false)

    @Before
    fun setupTest(){
        val intent = Intent()
        activityTestRule.launchActivity(intent)
    }

    @Test
    fun testActivityStart(){
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.repoList)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.homePb)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}