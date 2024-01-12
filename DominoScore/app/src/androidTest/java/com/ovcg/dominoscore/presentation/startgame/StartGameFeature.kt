package com.ovcg.dominoscore.presentation.startgame

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ovcg.dominoscore.R
import com.ovcg.dominoscore.utils.BaseUITest
import org.hamcrest.Matchers.allOf
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class StartGameFeature : BaseUITest() {

    @Test
    fun displayFieldsAndFillWithPlayersNames() {
        navigateToStartGameScreen()
        fillFieldsWithPlayers()
    }

    @Test
    fun navigateToGameScoreAfterFillingTheFields() {
        navigateToStartGameScreen()
        fillFieldsWithPlayers()
        navigateToGameScoreScreen()
    }

    @Test
    fun createGameAfterFillingPlayersFields() {
        navigateToStartGameScreen()

        fillFieldsWithPlayers()

        navigateToGameScoreScreen()

        validatePlayersFieldsDisplayed()
    }

    private fun validatePlayersFieldsDisplayed() {
        onView(withText("Player1"))
            .check(matches(isDisplayed()))
        onView(withText("Player2"))
            .check(matches(isDisplayed()))
        onView(withText("Player3"))
            .check(matches(isDisplayed()))
        onView(withText("Player4"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun displayLastGamesWithPartners() {
        navigateToStartGameScreen()
        onView(withId(R.id.button_last_games))
            .perform(click())
        onView(withText("Últimos jogos"))
            .check(matches(isDisplayed()))
        onView(allOf(withId(R.id.tv_game_name), isDescendantOfA(nthChildOf(withId(R.id.rv_last_games), 0))))
            .check(matches(withText("Game 1")))
            .check(matches(isDisplayed()))
    }

    private fun fillFieldsWithPlayers() {
        onView(withId(R.id.edt_first_player))
            .check(matches(isDisplayed()))
            .perform(typeText("Player1"))
        onView(withId(R.id.edt_second_player)).check(matches(isDisplayed()))
            .perform(typeText("Player2"))
        onView(withId(R.id.edt_third_player)).check(matches(isDisplayed()))
            .perform(typeText("Player3"))
        onView(withId(R.id.edt_fourth_player)).check(matches(isDisplayed()))
            .perform(typeText("Player4"))

        validatePlayersFieldsDisplayed()
    }

    private fun navigateToStartGameScreen() {
        onView(withId(R.id.button_home_start_score)).perform(ViewActions.click())
    }

    private fun navigateToGameScoreScreen() {
        onView(withId(R.id.button_go_to_game_score))
            .perform(click())
        onView(withId(R.id.game_score_root))
            .check(matches(isDisplayed()))
    }
}