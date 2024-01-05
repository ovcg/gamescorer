package com.ovcg.dominoscore.startgame

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
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
    fun displayFieldsAndFillWithPlayersNames() {
        navigateToStartGameScreen()
        fillFields()
    }

    @Test
    fun navigateToGameScoreAfterFillingTheFields() {
        navigateToStartGameScreen()
        fillFields()
        onView(withId(R.id.button_go_to_game_score))
            .perform(click())
        onView(withId(R.id.game_score_root))
            .check(matches(isDisplayed()))
    }

    private fun fillFields() {
        onView(withId(R.id.edt_first_player))
            .check(matches(isDisplayed()))
            .perform(typeText("Player1")).check(matches(withText("Player1")))
        onView(withId(R.id.edt_second_player)).check(matches(isDisplayed()))
            .perform(typeText("Player2")).check(matches(withText("Player2")))
        onView(withId(R.id.edt_third_player)).check(matches(isDisplayed()))
            .perform(typeText("Player3")).check(matches(withText("Player3")))
        onView(withId(R.id.edt_fourth_player)).check(matches(isDisplayed()))
            .perform(typeText("Player4")).check(matches(withText("Player4")))
    }

    private fun navigateToStartGameScreen() {
        onView(withId(R.id.button_home_start_score)).perform(ViewActions.click())
    }
}