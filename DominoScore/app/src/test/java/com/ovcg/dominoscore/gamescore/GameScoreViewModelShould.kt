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
    private val lastPlayers: List<Player> = mockk()
    private val expected = Result.success(lastPlayers)

    @Test
    fun getLastPlayersFromDatabase() {
        viewModel = mockSuccessfulCase()

        viewModel.players.getValueForTest()

        coVerify(exactly = 1) {
            useCase.getLastPlayers()
        }
    }

    @Test
    fun emitsListFromDataBase() {
        viewModel = mockSuccessfulCase()

        viewModel.players.getValueForTest()

        assertEquals(expected, viewModel.players.getValueForTest())
    }

    private fun mockSuccessfulCase(): GameScoreViewModel {
        coEvery { useCase.getLastPlayers() } returns flow { emit(Result.success(lastPlayers))}
        return GameScoreViewModel(useCase)
    }
}