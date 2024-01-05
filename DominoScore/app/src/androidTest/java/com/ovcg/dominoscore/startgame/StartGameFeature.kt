package com.ovcg.dominoscore.startgame

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ovcg.dominoscore.utils.BaseUITest
import org.junit.Test
import org.junit.runner.RunWith
import com.ovcg.dominoscore.R

@RunWith(AndroidJUnit4::class)
@LargeTest
class StartGameFeature : BaseUITest() {

    @Test
    fun displayFieldsToChoosePartners() {
        navigateToStartGameScreen()
        onView(withId(R.id.edt_first_player)).check(matches(isDisplayed()))
        onView(withId(R.id.edt_second_player)).check(matches(isDisplayed()))
        onView(withId(R.id.edt_third_player)).check(matches(isDisplayed()))
        onView(withId(R.id.edt_fourth_player)).check(matches(isDisplayed()))
    }

    private fun navigateToStartGameScreen() {
        onView(withId(R.id.button_home_start_score)).perform(ViewActions.click())
    }
}