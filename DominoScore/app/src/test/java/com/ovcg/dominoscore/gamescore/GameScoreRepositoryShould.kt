package com.ovcg.dominoscore.gamescore

import com.ovcg.dominoscore.data.database.GameScoreDao
import com.ovcg.dominoscore.data.database.entity.GameWithPlayers
import com.ovcg.dominoscore.data.repository.GameScoreRepositoryImpl
import com.ovcg.dominoscore.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GameScoreRepositoryShould : BaseUnitTest() {

    private val gamesDao: GameScoreDao = mockk()
    private val repository = GameScoreRepositoryImpl(gamesDao)
    private val games: List<GameWithPlayers> = mockk()
    private val exception = RuntimeException("Something went wrong")

    @Test
    fun getListOfLastGamesFromGameDao() {
        mockSuccessfulCase()

        runBlocking {
            repository.getLastGames()

            coVerify(exactly = 1) {
                gamesDao.getLastGames()
            }
        }
    }

    @Test
    fun emitsListOfLastGames() {
        mockSuccessfulCase()

        runBlocking {
            val actual = repository.getLastGames()

            assertEquals(games, actual.first().getOrNull()!!)
        }
    }

    private fun mockSuccessfulCase() {
        coEvery { gamesDao.getLastGames() } returns flow { emit(games) }
    }

}