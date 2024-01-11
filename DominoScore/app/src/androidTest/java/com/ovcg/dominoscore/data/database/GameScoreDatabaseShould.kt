package com.ovcg.dominoscore.data.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ovcg.dominoscore.data.database.entity.GamePlayerCrossRef
import com.ovcg.dominoscore.utils.GameScoreUtil
import junit.framework.TestCase
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class GameScoreDatabaseShould : TestCase() {

    private lateinit var gameScoreDao: GameScoreDao
    private lateinit var db: GameScoreDatabase

    @Before
    fun createDB() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, GameScoreDatabase::class.java).build()
        gameScoreDao = db.gameDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDB() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeGameAndReadInList() {
        val players = GameScoreUtil.createPlayers()
        val game = GameScoreUtil.createGame()
        runBlocking {
            gameScoreDao.insertGame(game)
            players.forEach { player ->
                gameScoreDao.insertPlayer(player)
                gameScoreDao.insertGameCrossPlayers(
                    GamePlayerCrossRef(
                        gameId = game.gameId,
                        playerId = player.playerId
                    )
                )
            }

            val gameWithPlayers = gameScoreDao.getLastGames().single()
            val gameQueried = gameWithPlayers[0].game
            assertEquals(gameQueried.title, game.title)
        }
    }
}