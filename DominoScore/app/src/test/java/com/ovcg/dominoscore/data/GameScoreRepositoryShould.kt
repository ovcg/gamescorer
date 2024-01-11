package com.ovcg.dominoscore.data

import com.ovcg.dominoscore.data.database.GameScoreDao
import com.ovcg.dominoscore.data.database.entity.GameWithPlayers
import com.ovcg.dominoscore.data.repository.GameScoreRepositoryImpl
import com.ovcg.dominoscore.utils.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GameScoreRepositoryShould : BaseUnitTest() {

    private val gameScoreDao: GameScoreDao = mockk()
    private val repository = GameScoreRepositoryImpl(gameScoreDao)
    private val games: List<GameWithPlayers> = mockk()

    @Test
    fun getListOfLastGamesFromGameDao() {
        mockSuccessfulCase()

        runBlocking {
            repository.getLastGames()

            coVerify(exactly = 1) {
                gameScoreDao.getLastGames()
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
        coEvery {  gameScoreDao.getLastGames() } returns games
    }

}