package com.ovcg.dominoscore

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeFeature {

    @get:Rule
    val mActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun displayTitleAndHomeButtons() {
        onView(withId(R.id.home_title)).check(matches(withText("Domino Score")))

        onView(withId(R.id.button_home_start_score)).check(matches(isDisplayed()))

        onView(withId(R.id.button_home_game_history)).check(matches(isDisplayed()))
    }

    @Test
    fun navigateToStartScreen() {
        onView(withId(R.id.button_home_start_score)).perform(click())

        onView(withText("Escolha sua dupla")).check(matches(isDisplayed()))
    }

    @Test
    fun navigateToHistoryScreen() {
        onView(withId(R.id.button_home_game_history)).perform(click())

        onView(withText("Histórico de partidas")).check(matches(isDisplayed()))
    }
}