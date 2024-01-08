package com.ovcg.dominoscore.gamescore

import com.ovcg.dominoscore.utils.getValueForTest
import com.ovcg.dominoscore.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import org.junit.Assert.assertEquals
import org.junit.Test

class GameScoreViewModelShould : BaseUnitTest() {

    private var useCase: GameScoreUseCase = mockk()
    private lateinit var viewModel: GameScoreViewModel
    private val lastGames: List<Game> = mockk()
    private val expected = Result.success(lastGames)
    private val exception = RuntimeException("Something went wrong")
    @Test
    fun getLastGamesFromDatabase() {
        viewModel = mockSuccessfulCase()

        viewModel.games.getValueForTest()

        coVerify(exactly = 1) {
            useCase.getLastGames()
        }
    }

    @Test
    fun emitsListFromDataBase() {
        viewModel = mockSuccessfulCase()

        viewModel.games.getValueForTest()

        assertEquals(expected, viewModel.games.getValueForTest())
    }

    @Test
    fun emitsErrorWhenGetListOfGames() {
        coEvery { useCase.getLastGames() } returns flow { emit(Result.failure(exception)) }
        viewModel = GameScoreViewModel(useCase)

        viewModel.games.getValueForTest()

        assertEquals(exception, viewModel.games.getValueForTest()!!.exceptionOrNull())

    }

    private fun mockSuccessfulCase(): GameScoreViewModel {
        coEvery { useCase.getLastGames() } returns flow { emit(Result.success(lastGames))}
        return GameScoreViewModel(useCase)
    }
}