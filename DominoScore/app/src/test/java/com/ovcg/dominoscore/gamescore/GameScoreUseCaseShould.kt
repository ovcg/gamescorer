package com.ovcg.dominoscore.gamescore

import com.ovcg.dominoscore.presentation.gamescore.Game
import com.ovcg.dominoscore.data.GameScoreRepository
import com.ovcg.dominoscore.domain.GameScoreUseCase
import com.ovcg.dominoscore.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GameScoreUseCaseShould : BaseUnitTest() {

    private val repository: GameScoreRepository = mockk()
    private val useCase = GameScoreUseCase(repository)
    private val games: List<Game> = mockk()
    private val exception = RuntimeException("Something went wrong")

    @Test
    fun getLastGamesListFromRepository() {
        mockSuccessfulCase()

        runBlocking {
            useCase.getLastGames()

            coVerify(exactly = 1) {
                repository.getLastGames()
            }
        }
    }

    @Test
    fun emitLastGamesListFromRepository() {
        mockSuccessfulCase()

        runBlocking {
            val actual = useCase.getLastGames()

            assertEquals(games, actual.first().getOrNull())
        }
    }

    @Test
    fun propagateErrorWhenGetGamesList() {
        coEvery { repository.getLastGames() } returns flow { emit(Result.failure(exception)) }

        runBlocking {
            assertEquals(exception, useCase.getLastGames().first().exceptionOrNull())
        }

    }

    private fun mockSuccessfulCase() {
        coEvery { repository.getLastGames() } returns flow { emit(Result.success(games)) }
    }

}