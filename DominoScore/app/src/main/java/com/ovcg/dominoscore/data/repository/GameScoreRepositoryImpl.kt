package com.ovcg.dominoscore.data.repository

import android.util.Log
import com.ovcg.dominoscore.data.database.GameScoreDao
import com.ovcg.dominoscore.data.database.entity.GamePlayerCrossRef
import com.ovcg.dominoscore.data.database.entity.GameWithPlayers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameScoreRepositoryImpl @Inject constructor(
    private val gameScoreDao: GameScoreDao
) : GameScoreRepository {
    override suspend fun getLastGames(): Flow<Result<List<GameWithPlayers>>> {
        return flow {
            val result = withContext(Dispatchers.IO) { gameScoreDao.getLastGames() }
            emit(Result.success(result))
        }.catch {
            Log.e("APP_ERROR = ", it.message ?: "IHHHH")
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }

    override suspend fun insertGame(gameWithPlayers: GameWithPlayers) {
        gameScoreDao.apply {
            insertGame(gameWithPlayers.game)
            gameWithPlayers.players.forEach { player ->
                insertPlayer(player)
                insertGameCrossPlayers(
                    GamePlayerCrossRef(
                        gameId = gameWithPlayers.game.gameId,
                        playerId = player.playerId
                    )
                )
            }
        }
    }
}