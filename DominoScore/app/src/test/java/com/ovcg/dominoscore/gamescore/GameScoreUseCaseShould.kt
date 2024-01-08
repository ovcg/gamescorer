package com.ovcg.dominoscore.gamescore

import com.ovcg.dominoscore.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GameScoreUseCaseShould : BaseUnitTest() {

    private val repository: GameScoreRepository = mockk()
    private val useCase = GameScoreUseCase(repository)
    private val games: List<Game> = mockk()

    @Test
    fun getLastGamesListFromRepository() {
        coEvery { repository.getLastGames() } returns flow { Result.success(games) }

        runBlocking {
            useCase.getLastGames()

            coVerify(exactly = 1) {
                repository.getLastGames()
            }
        }
    }


}